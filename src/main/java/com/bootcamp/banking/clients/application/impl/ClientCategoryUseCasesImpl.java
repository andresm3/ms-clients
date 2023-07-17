package com.bootcamp.banking.clients.application.impl;

import com.bootcamp.banking.clients.application.ClientCategoryUseCases;
import com.bootcamp.banking.clients.domain.models.ClientCategory;
import com.bootcamp.banking.clients.domain.dto.ClientCategoryRequest;
import com.bootcamp.banking.clients.infraestructure.repository.ClientCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientCategoryUseCasesImpl implements ClientCategoryUseCases {

  @Autowired
  private ClientCategoryRepository clientCategoryRepository;
  @Override
  public Flux<ClientCategory> getAll() {
    return clientCategoryRepository.findAll();
  }

  @Override
  public Mono<ClientCategory> createClientCategory(ClientCategoryRequest clientCategoryRequest) {
    return clientCategoryRepository.save(this.fromClientCategoryRequestToClientCategory(clientCategoryRequest));
  }

  private ClientCategory fromClientCategoryRequestToClientCategory(ClientCategoryRequest clientCategoryRequest) {
    ClientCategory clientCategory = new ClientCategory();
    clientCategory.setCategoryName(clientCategoryRequest.getCategoryName());
    return clientCategory;
  }
}
