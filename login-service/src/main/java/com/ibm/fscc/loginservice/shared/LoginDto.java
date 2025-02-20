package com.ibm.fscc.loginservice.shared;

/* A Data Transfer Object (DTO) is a design pattern used in
software development to transfer data between layers of an application,
such as between the presentation layer and the business logic layer, or
between the business logic layer and the data access layer.*/

public class LoginDto {
    //Private fields
    private String userName;

    private String password;

    private String email;

    private Long id;

    // The purpose of each constructor is to provide a way to create instances of the `LoginDto` class with different sets of data.
    public LoginDto(String userName, String password, String email, Long id) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.id = id;
    }
    public LoginDto(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


    //Getter methods are used to retrieve the value of a private field in an object.

    //Setter methods are used to modify the value of a private field in an object.

    public LoginDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /* The purpose of the `toString` method is to provide
    a string representation of the `LoginDto` object.
    This method is used to return a string that describes the
    object's state, making it easier to debug and log the object's values.*/

    @Override
    public String toString() {
        return "LoginDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
