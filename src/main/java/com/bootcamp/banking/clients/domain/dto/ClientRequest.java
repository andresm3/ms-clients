package com.bootcamp.banking.clients.domain.dto;

import lombok.Data;

@Data
public class ClientRequest {

  private String documentType;
  private String documentNumber;
  private String name;
  private String firstName;
  private String lastName;
  private int type;
  private int profile;
  private boolean active;
  private String idClientCategory;
}
