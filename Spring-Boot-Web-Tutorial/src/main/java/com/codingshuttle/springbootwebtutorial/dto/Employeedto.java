package com.codingshuttle.springbootwebtutorial.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "name filed should not be blank")
   @Size(min=3,max=10)
    private String name;
    @Email(message="email must be valid in format")
    private String email;
@Pattern(regexp = "^(ADMIN|USER)$")
private String role;

    @Max(value=80,message = "age cannot be greater than 80")
    @Min(value=18,message ="age cannot be less than 18")
    private Integer age;

    @PastOrPresent(message = "date must be past  or present ")
    private LocalDate dateofJoining;
    @AssertTrue()
@JsonProperty("isActive")
private Boolean isActive;
@Digits(integer = 6,fraction = 2,message = "the salary is im form of xxyx")
@DecimalMax(value="100000.24")
@DecimalMin(value="100.24")
private Double salary;

}
