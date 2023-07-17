package com.bootcamp.banking.clients.infraestructure.repository;

import com.bootcamp.banking.clients.domain.models.ClientCategory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientCategoryRepository extends
  ReactiveMongoRepository<ClientCategory, String> {

}
