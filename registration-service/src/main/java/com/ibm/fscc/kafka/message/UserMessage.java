package com.ibm.fscc.kafka.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class UserMessage {

    private String location;

    private String cell_phone;

    private String home_phone;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private OffsetDateTime timestamp;
}
