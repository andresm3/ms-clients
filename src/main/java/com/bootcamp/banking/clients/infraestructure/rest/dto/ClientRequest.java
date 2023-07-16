package com.bootcamp.banking.clients.infraestructure.rest.dto;

import lombok.Data;

@Data
public class ClientRequest {

  private String documentType;
  private String documentNumber;
  private String name;

  private String idClientCategory;
}
