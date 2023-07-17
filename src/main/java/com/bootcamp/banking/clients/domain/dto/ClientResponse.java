package com.bootcamp.banking.clients.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientResponse {

  @JsonProperty("id")
  private String id;
  private String documentType;
  private String documentNumber;
  private String name;

  private String idClientCategory;
}
