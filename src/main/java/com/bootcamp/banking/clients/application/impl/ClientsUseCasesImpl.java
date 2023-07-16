package com.bootcamp.banking.clients.application.impl;

import com.bootcamp.banking.clients.application.ClientsUseCases;
import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.domain.repository.ClientRepository;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientsUseCasesImpl implements ClientsUseCases {

  @Autowired
  private ClientRepository clientRepository;


  @Override
  public Flux<Client> getAllClients() {
    return clientRepository.findAll();
  }

  @Override
  public Mono<Client> getClientById(String id) {
    return clientRepository.findById(id);
  }

  @Override
  public Mono<Client> createClient(ClientRequest clientRequest) {
    return clientRepository.save(this.fromClientRequestToClient(clientRequest));
  }

  @Override
  public Mono<Client> deleteClient(String id) {
    return null;
  }

  private Client fromClientRequestToClient(ClientRequest clientRequest) {
    Client client = new Client();
    client.setName(clientRequest.getName());
    client.setDocumentType(clientRequest.getDocumentType());
    client.setDocumentNumber(clientRequest.getDocumentNumber());
    client.setIdClientCategory(clientRequest.getIdClientCategory());
    return client;
  }

}
