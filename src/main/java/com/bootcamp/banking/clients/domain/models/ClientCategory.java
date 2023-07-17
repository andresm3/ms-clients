package com.bootcamp.banking.clients.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clientCategory")
public class ClientCategory {

  @Id
  private String id;
  private String categoryName;
}
