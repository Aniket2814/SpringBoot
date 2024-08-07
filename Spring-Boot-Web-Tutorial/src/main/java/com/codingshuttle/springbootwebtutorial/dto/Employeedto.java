package com.codingshuttle.springbootwebtutorial.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employeedto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
private LocalDate dateofJoining;
@JsonProperty("isActive")
private Boolean isActive;


}
