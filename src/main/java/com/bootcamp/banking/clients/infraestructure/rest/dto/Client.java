package com.bootcamp.banking.clients.infraestructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Client {

  @JsonProperty("id")
  private String id;
  private String documentType;
  private String documentNumber;
  private String name;

  private String idClientCategory;
}
