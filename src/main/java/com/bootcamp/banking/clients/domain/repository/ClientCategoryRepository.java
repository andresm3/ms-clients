package com.bootcamp.banking.clients.domain.repository;

import com.bootcamp.banking.clients.domain.repository.dao.ClientCategoryDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientCategoryRepository extends ReactiveMongoRepository<ClientCategoryDao,String> {
}
