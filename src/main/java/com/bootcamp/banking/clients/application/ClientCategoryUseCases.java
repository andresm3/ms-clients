package com.bootcamp.banking.clients.application;

import com.bootcamp.banking.clients.domain.models.ClientCategory;
import com.bootcamp.banking.clients.domain.models.dto.ClientCategoryRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientCategoryUseCases {

  Flux<ClientCategory> getAll();

  Mono<ClientCategory> createClientCategory(ClientCategoryRequest clientCategoryRequest);

}
