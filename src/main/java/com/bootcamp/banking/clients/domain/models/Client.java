package com.bootcamp.banking.clients.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clients")
public class Client {
    @JsonProperty("id")
    private String id;
    private String documentType;
    private String documentNumber;
    private String name;

    private String idClientCategory;
}
