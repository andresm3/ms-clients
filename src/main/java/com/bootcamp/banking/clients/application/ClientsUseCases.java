package com.bootcamp.banking.clients.application;

import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.domain.models.dto.ClientResponse;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsUseCases {

    public Flux<Client>getAllClients();

    public Mono<Client>getClientById(String id);
    public Mono<Client> createClient(ClientRequest clientRequest);
    public Mono<Client>deleteClient(String id);
}
