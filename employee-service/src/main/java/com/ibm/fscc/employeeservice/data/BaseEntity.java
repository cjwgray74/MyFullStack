package com.ibm.fscc.employeeservice.data;

//The import statements import various classes and interfaces from different packages, allowing the application to use them.
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDateTime;


@MappedSuperclass //Use the `@MappedSuperclass` annotation to mark a class as a mapped superclass. Not a top-level entity.
@Data //Use the `@Data` annotation to automatically generate getters and setters for fields.

/*The `BaseEntity` class is a mapped superclass that provides properties and methods that can be inherited by other entities.
* It contains `created_at`, `created_by`, `updated_at`, and `updated_by.` */
public class BaseEntity {

    //Use the `@Column` annotation to specify column properties.
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;

}
