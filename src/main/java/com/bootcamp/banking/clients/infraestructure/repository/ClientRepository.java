package com.bootcamp.banking.clients.infraestructure.repository;

import com.bootcamp.banking.clients.infraestructure.repository.dao.ClientDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<ClientDao,String> {
}
