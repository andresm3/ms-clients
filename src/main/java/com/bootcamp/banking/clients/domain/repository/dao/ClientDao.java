package com.bootcamp.banking.clients.domain.repository.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clients")
public class ClientDao {

  @Id
  private String id;
  private String documentType;
  private String documentNumber;
  private String name;
  private String idClientCategory;
}
