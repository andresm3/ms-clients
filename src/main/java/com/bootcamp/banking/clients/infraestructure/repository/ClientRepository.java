package com.bootcamp.banking.clients.infraestructure.repository;

import com.bootcamp.banking.clients.domain.models.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}