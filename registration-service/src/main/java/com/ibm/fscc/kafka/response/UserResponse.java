package com.ibm.fscc.kafka.response;

public class UserResponse {

    private String id;

    public UserResponse(String id) {

        this.id = id;
    }

    public UserResponse() {
    }

    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
