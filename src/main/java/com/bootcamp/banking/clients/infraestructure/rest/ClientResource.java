package com.bootcamp.banking.clients.infraestructure.rest;

import com.bootcamp.banking.clients.application.ClientUseCases;
import com.bootcamp.banking.clients.domain.models.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientResource {

  @Autowired
  private ClientUseCases clientUseCases;

  @GetMapping
  public Flux<Client> getAll() {
    return clientUseCases.getAllClients();
  }

  @GetMapping("/id/{id}")
  public Mono<Client> findClientById(@PathVariable String id) {
    return clientUseCases.getClientById(id);
  }

  @GetMapping("/document/{documentNumber}")
  public Mono<Client> findClientByDocumentNumber(@PathVariable String documentNumber) {
    return clientUseCases.getClientByDocumentNumber(documentNumber);
  }

  @GetMapping("/lastname/{lastName}")
  public Flux<Client> findClientByLastName(@PathVariable String lastName) {
    return clientUseCases.getClientByLastName(lastName);
  }
  @PostMapping
  public Mono<Client> createClient(@RequestBody Client client) {
    return clientUseCases.createClient(client);
  }
}
