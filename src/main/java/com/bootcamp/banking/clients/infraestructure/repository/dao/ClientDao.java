package com.bootcamp.banking.clients.infraestructure.repository.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

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
