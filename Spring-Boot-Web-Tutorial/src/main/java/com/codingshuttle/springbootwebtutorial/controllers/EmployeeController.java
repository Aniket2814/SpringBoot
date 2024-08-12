package com.codingshuttle.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.dto.Employeedto;
import com.codingshuttle.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.repositories.EmployeeRepository;
import com.codingshuttle.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    //@GetMapping(path="/getSecretMessage")
//    public String getMySecretMessage()
//{
//    return "Secret Message:--- I Love BULBUL";
//}
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{employeeID}")
    public ResponseEntity<Employeedto> getEmployeeById(@PathVariable(name = "employeeID") Long id) {
        Optional<Employeedto> employeedto= employeeService.getEmployeeById(id);
//if(employeedto==null) return ResponseEntity.notFound().build();
//return ResponseEntity.ok(employeedto);
  return employeedto.map(employeedto1 ->ResponseEntity.ok(employeedto1))
           .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<Employeedto>> getAllEmployee(@RequestParam(required = false, name = "age123") Integer age) {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    //@PostMapping
//    public String createNewEmployee()
//{
//    return "hello world";
//}
    @PostMapping
    public ResponseEntity<Employeedto> createNewEmployee(@RequestBody @Valid Employeedto inputemp) {

        Employeedto savedEmployee= employeeService.createNewEmployee(inputemp);
return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeID}")
    public ResponseEntity<Employeedto> updateEmployeeById(@RequestBody @Valid  Employeedto employeedto, @PathVariable Long employeeID) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeID, employeedto));
    }

    @DeleteMapping(path = "/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeID) {
boolean gotDeleted= employeeService.deleteEmployeeById(employeeID);
   if(gotDeleted)     return ResponseEntity.ok(true);
   return ResponseEntity.notFound().build();

    }

    @PatchMapping(path = "/{employeeID}")
    public ResponseEntity<Employeedto> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeID) {
      Employeedto employeedto= employeeService.updatePartialEmployeeById(employeeID, updates);
if(employeedto==null)
{
    return ResponseEntity.notFound().build();
}
return ResponseEntity.ok(employeedto);
    }
}


