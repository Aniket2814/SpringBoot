package com.codingshuttle.springbootwebtutorial.services;

import com.codingshuttle.springbootwebtutorial.dto.Employeedto;
import com.codingshuttle.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Employeedto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //ModelMapper modelMapper=new ModelMapper();
        //soruce,destination
        return modelMapper.map(employeeEntity, Employeedto.class);
    }

    public List<Employeedto> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, Employeedto.class))
                .collect(Collectors.toList());
    }


    public Employeedto createNewEmployee(EmployeeEntity inputemp) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputemp, EmployeeEntity.class);
        EmployeeEntity SavedemployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(SavedemployeeEntity, Employeedto.class);
    }


    public Employeedto updateEmployeeById(Long employeeID, Employeedto employeedto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeedto, EmployeeEntity.class);
        employeeEntity.setId(employeeID);
        EmployeeEntity savedemployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedemployeeEntity, Employeedto.class);
    }

    public boolean deleteEmployeeById(Long employeeID) {
boolean exists=employeeRepository.existsById(employeeID);
if(!exists) return false;

employeeRepository.deleteById(employeeID);
return  true;
    }
}