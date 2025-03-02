package com.ibm.fscc.kafka.broker;


import com.ibm.fscc.kafka.model.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserMessage {

    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public UserEntity toUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setStatus(status);
        return userEntity;
    }


}
