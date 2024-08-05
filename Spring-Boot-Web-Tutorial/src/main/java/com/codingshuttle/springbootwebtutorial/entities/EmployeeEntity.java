package com.codingshuttle.springbootwebtutorial.entities;

import jakarta.persistence.*;
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
    private Boolean isActive;



}
