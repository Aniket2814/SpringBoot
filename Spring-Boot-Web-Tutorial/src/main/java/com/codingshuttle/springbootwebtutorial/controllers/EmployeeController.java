package com.codingshuttle.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.dto.Employeedto;
import com.codingshuttle.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.repositories.EmployeeRepository;
import com.codingshuttle.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
    public Employeedto getEmployeeById(@PathVariable(name ="employeeID") Long id)
{
    return employeeService.getEmployeeById(id);
            
}
@GetMapping
    public List<Employeedto> getAllEmployee(@RequestParam(required = false,name ="age123") Integer age)
{
    return employeeService.getAllEmployee();
}
//@PostMapping
//    public String createNewEmployee()
//{
//    return "hello world";
//}
@PostMapping
    public Employeedto createNewEmplolyee( @RequestBody EmployeeEntity inputemp)
{

return employeeService.createNewEmployee(inputemp);

}
@PutMapping(path="/{employeeID}")
public Employeedto updateEmployeeById(@RequestBody Employeedto employeedto,@PathVariable Long employeeID)
{
    return employeeService.updateEmployeeById(employeeID,employeedto);
}
@DeleteMapping(path="/{employeeID}")
    public boolean deleteEmployeeById(@PathVariable Long employeeID)
{
    return employeeService.deleteEmployeeById(employeeID);

}
@PatchMapping(path="/{employeeID}")
public Employeedto updatePartialEmployeeById(employeeID,Employeedto)
}
HashSet

