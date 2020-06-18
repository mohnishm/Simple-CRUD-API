package com.puratis.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel(description="All details about the student. ")
@Document(collection = "student")
public class Student {
    @Id
    @JsonIgnore
    private String id;
    @NotNull(message = "Name cannot be null.")
    @NotBlank
    private String name;
    @NotBlank
    @NotNull(message = "Roll number cannot be null.")
    private String rollNumber;

    public Student() {
        super();
    }

    public Student(String id, String name, String rollNumber) {
        super();
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }
}
