package com.codingshuttle.springbootwebtutorial.entities;

import com.codingshuttle.springbootwebtutorial.dto.Employeedto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity
//
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="employees")
public class EmployeeEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateofJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

    private String role;

    private Double salary;
}
