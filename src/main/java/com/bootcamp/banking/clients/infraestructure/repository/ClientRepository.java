package com.bootcamp.banking.clients.infraestructure.repository;

import com.bootcamp.banking.clients.domain.models.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

  Mono<Client> findByDocumentNumber(String documentNumber);
  Flux<Client> findByLastName(String lastName);
}
