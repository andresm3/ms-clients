package com.bootcamp.banking.clients.domain.repository;

import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.domain.repository.dao.ClientDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client,String> {
}
