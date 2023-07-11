package com.bootcamp.banking.clients.infraestructure.repository;

import com.bootcamp.banking.clients.infraestructure.repository.dao.ClientCategoryDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientCategoryRepository extends ReactiveMongoRepository<ClientCategoryDao,String> {
}
