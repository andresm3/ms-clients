package com.bootcamp.banking.clients.infraestructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientCategory {

  @JsonProperty("id")
  private String id;
  private String clientCategory;
}
