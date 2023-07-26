package com.bootcamp.banking.clients.application.impl;

import com.bootcamp.banking.clients.application.ClientUseCases;
import com.bootcamp.banking.clients.application.exceptions.CustomNotFoundException;
import com.bootcamp.banking.clients.application.utils.Validations;
import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.domain.dto.ClientRequest;
import com.bootcamp.banking.clients.infraestructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientUseCasesImpl implements ClientUseCases {

  @Autowired
  private ClientRepository clientRepository;


  @Override
  public Flux<Client> getAllClients() {
    return clientRepository.findAll();
  }

  @Override
  public Mono<Client> getClientById(String id) {
    return clientRepository.findById(id)
        .switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
  }

  @Override
  public Mono<Client> getClientByDocumentNumber(String documentNumber) {
    return clientRepository.findByDocumentNumber(documentNumber)
        .switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
  }

  @Override
  public Flux<Client> getClientByLastName(String lastName) {
    return clientRepository.findByLastName(lastName);
  }

  @Override
  public Mono<Client> createClient(Client client) {
    // return clientRepository.save(this.fromClientRequestToClient(clientRequest));
    return Validations.validateCreateClient(client)
        .flatMap(c -> clientRepository.findByDocumentNumber(client.getDocumentNumber())
            .switchIfEmpty(clientRepository.save(client)
                .map(x -> {
                  return x;
                })
            ));
  }

  @Override
  public Mono<Client> deleteClient(String id) {
    return clientRepository.findById(id)
        .map(client -> {
          client.setActive(false);
          clientRepository.save(client).subscribe();
          return client;
        });
  }

  private Client fromClientRequestToClient(ClientRequest clientRequest) {
    Client client = new Client();
    client.setFirstName(clientRequest.getFirstName());
    client.setLastName(clientRequest.getLastName());
    client.setDocumentType(clientRequest.getDocumentType());
    client.setDocumentNumber(clientRequest.getDocumentNumber());
    client.setProfile(clientRequest.getProfile());
    return client;
  }

}
