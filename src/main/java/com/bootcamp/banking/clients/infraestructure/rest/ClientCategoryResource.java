package com.bootcamp.banking.clients.infraestructure.rest;

import com.bootcamp.banking.clients.application.ClientCategoryUseCases;
import com.bootcamp.banking.clients.domain.dto.ClientCategoryRequest;
import com.bootcamp.banking.clients.domain.models.ClientCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientCategory")
public class ClientCategoryResource {

  @Autowired
  private ClientCategoryUseCases clientCategoryUseCases;

  @GetMapping
  public Flux<ClientCategory> getAll() {
    return clientCategoryUseCases.getAll();
  }

  @PostMapping
  public Mono<ClientCategory> createClientCategory(
    @RequestBody ClientCategoryRequest clientCategoryRequest) {
    return clientCategoryUseCases.createClientCategory(clientCategoryRequest);
  }
}
