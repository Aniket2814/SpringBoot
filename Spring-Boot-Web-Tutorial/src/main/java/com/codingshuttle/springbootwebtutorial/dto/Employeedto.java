package com.codingshuttle.springbootwebtutorial.dto;
import java.time.LocalDate;
public class Employeedto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
private LocalDate dateofJoining;
private Boolean isActive;

    public Employeedto(Long id, String name, String email, LocalDate dateofJoining, Integer age, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateofJoining = dateofJoining;
        this.age = age;
        this.isActive = isActive;
    }

    public Employeedto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
