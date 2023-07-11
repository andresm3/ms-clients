package com.bootcamp.banking.clients.infraestructure.rest;

import com.bootcamp.banking.clients.infraestructure.repository.ClientRepository;
import com.bootcamp.banking.clients.infraestructure.repository.dao.ClientDao;
import com.bootcamp.banking.clients.infraestructure.rest.dto.Client;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientResource {

    private final ClientRepository clientRepository;

    @GetMapping
    public Flux<Client> getAll() {
        return clientRepository.findAll()
                .map(this::fromClientDaoToClientDto);
    }

    @GetMapping("/{id}")
    public Mono<Client> findClientById(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(this::fromClientDaoToClientDto);
    }

    @PostMapping
    public Mono<Client> createClient(@RequestBody ClientRequest client) {
        return clientRepository.save(this.fromClientRequestToClientDao(client))
                .map(this::fromClientDaoToClientDto);
    }
    private Client fromClientDaoToClientDto(ClientDao dao) {
        Client client = new Client();
        client.setId(dao.getId());
        client.setDocumentNumber(dao.getDocumentNumber());
        client.setDocumentType(dao.getDocumentType());
        client.setName(dao.getName());
        client.setIdClientCategory(dao.getIdClientCategory());
        return client;
    }

    private ClientDao fromClientRequestToClientDao(ClientRequest clientRequest) {
        ClientDao client = new ClientDao();
        client.setName(clientRequest.getName());
        client.setDocumentType(clientRequest.getDocumentType());
        client.setDocumentNumber(clientRequest.getDocumentNumber());
        client.setIdClientCategory(clientRequest.getIdClientCategory());
        return client;
    }
}
