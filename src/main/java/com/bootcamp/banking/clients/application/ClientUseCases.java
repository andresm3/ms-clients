package com.bootcamp.banking.clients.application;

import com.bootcamp.banking.clients.domain.models.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientUseCases {

  Flux<Client> getAllClients();

  Mono<Client> getClientById(String id);
  Mono<Client> getClientByDocumentNumber(String id);
  Flux<Client> getClientByLastName(String lastName);

  Mono<Client> createClient(Client clientRequest);

  Mono<Client> deleteClient(String id);
}
