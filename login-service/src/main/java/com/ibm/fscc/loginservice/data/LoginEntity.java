package com.ibm.fscc.loginservice.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data //Used to automatically generate getters and setters for fields.

@Entity //Used to indicate that a class is an entity.
@Table(name="login") //Used to specify the name of the table in the database.
public class LoginEntity {


	@Id // Used to indicate that a field is the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for generating the value of a primary key field

	//  Use the `@Column` annotation to specify the properties of a field in a database table.
	@Column(name = "id", length = 45)
	private Long id; // primary and generated

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email; // Unique

	@Column(name = "username", length = 255, nullable = false)
	private String userName;

	@Column(name = "password", length = 255, nullable = false)
	private String password;


	public LoginEntity(Long id, String email, String userName, String password) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public LoginEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginEntity{" +
				"id=" + id +
				", email='" + email + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
