package com.bootcamp.banking.clients.infraestructure.rest;

import com.bootcamp.banking.clients.infraestructure.repository.ClientCategoryRepository;
import com.bootcamp.banking.clients.domain.repository.dao.ClientCategoryDao;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientCategory;
import com.bootcamp.banking.clients.infraestructure.rest.dto.ClientCategoryRequest;
import lombok.RequiredArgsConstructor;
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

  private final ClientCategoryRepository clientCategoryRepository;

  @GetMapping
  public Flux<ClientCategory> getAll() {
    return clientCategoryRepository.findAll()
      .map(this::fromClientCategoryDaoToClientCategoryDto);
  }

  @PostMapping
  public Mono<ClientCategory> createClientCategory(
    @RequestBody ClientCategoryRequest clientCategoryRequest) {
    return clientCategoryRepository.save(
        this.fromClientCategoryRequestToClientCategoryDao(clientCategoryRequest))
      .map(this::fromClientCategoryDaoToClientCategoryDto);
  }

  private ClientCategory fromClientCategoryDaoToClientCategoryDto(ClientCategoryDao dao) {
    ClientCategory clientCategory = new ClientCategory();
    clientCategory.setId(dao.getId());
    clientCategory.setClientCategory(dao.getCategoryName());
    return clientCategory;
  }

  private ClientCategoryDao fromClientCategoryRequestToClientCategoryDao(
    ClientCategoryRequest clientCategoryRequest) {
    ClientCategoryDao clientCategoryDao = new ClientCategoryDao();
    clientCategoryDao.setCategoryName(clientCategoryRequest.getCategoryName());
    return clientCategoryDao;
  }
}
