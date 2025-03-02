package com.ibm.fscc.kafka.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@Getter @Setter
public class UserEntity implements Serializable {

    private String firstName;

    private String lastName;

    @Id
    private String email;

    private String status;

}

