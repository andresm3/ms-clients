package com.bootcamp.banking.clients.domain.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientCategoryResponse {

  @JsonProperty("id")
  private String id;
  private String categoryName;
}
