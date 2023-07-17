package com.bootcamp.banking.clients.application;

import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.domain.models.dto.ClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientUseCases {

  Flux<Client> getAllClients();

  Mono<Client> getClientById(String id);

  Mono<Client> createClient(ClientRequest clientRequest);

  Mono<Client> deleteClient(String id);
}
