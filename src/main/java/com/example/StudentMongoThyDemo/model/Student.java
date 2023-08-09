package com.example.StudentMongoThyDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String detail;
    private int age;

}
