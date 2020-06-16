package com.puratis.project.student;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@ApiModel(description="All details about the student. ")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Name cannot be null.")
    @NotBlank
    private String name;
    @NotBlank
    @NotNull(message = "Roll number cannot be null.")
    private String rollNumber;

    public Student() {
        super();
    }

    public Student(Long id, String name, String rollNumber) {
        super();
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }
}
