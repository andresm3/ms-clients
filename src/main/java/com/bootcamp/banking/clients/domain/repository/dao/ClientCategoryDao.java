package com.bootcamp.banking.clients.domain.repository.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clientCategory")
public class ClientCategoryDao {

  @Id
  private String id;
  private String clientCategory;
}
