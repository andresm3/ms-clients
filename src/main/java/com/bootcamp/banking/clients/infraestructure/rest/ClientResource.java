package com.bootcamp.banking.clients.infraestructure.rest;

import com.bootcamp.banking.clients.application.ClientsUseCases;
import com.bootcamp.banking.clients.domain.repository.ClientRepository;
import com.bootcamp.banking.clients.domain.repository.dao.ClientDao;
// import com.bootcamp.banking.clients.infraestructure.rest.dto.Client;
import com.bootcamp.banking.clients.domain.models.Client;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    private ClientsUseCases clientsUseCases;

    @GetMapping
    public Flux<Client> getAll() {
        return clientsUseCases.getAllClients();
    }

    @GetMapping("/{id}")
    public Mono<Client> findClientById(@PathVariable String id) {
        return clientsUseCases.getClientById(id);
    }

    @PostMapping
    public Mono<Client> createClient(@RequestBody ClientRequest client) {
        return clientsUseCases.createClient(client);
    }
}
