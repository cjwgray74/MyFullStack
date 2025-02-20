package com.ibm.fscc.employeeservice.data;

//The import statements import various classes and interfaces from different packages, allowing the application to use them.
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data //Used to automatically generate getters and setters for fields.
@NoArgsConstructor // Used to generate a no-argument constructor.
@Entity //Used to indicate that a class is an entity.
@Table(name="employees") //Used to specify the name of the table in the database.
public class EmployeeEntity extends BaseEntity {
	
	@Id // Used to indicate that a field is the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for generating the value of a primary key field

	//  Use the `@Column` annotation to specify the properties of a field in a database table.
	@Column(name = "id")
	private Long id; // primary and generated
	
	@Column(name = "uuid", nullable = false, unique = true)
	private String userId = UUID.randomUUID().toString(); // Generate with UUID and unique
	
	@Column(name = "first_name", nullable = false)
	private String firstName; 
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "address", nullable = false)
	private String address; 
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "zip", nullable = false)
	private String zip;
	
	@Column(name = "cell_phone", nullable = false, unique = true)
	private String cellPhone;
	
	@Column(name = "home_phone")
	private String homePhone;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email; // Unique



}
