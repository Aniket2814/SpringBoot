package com.codingshuttle.springbootwebtutorial.services;

import com.codingshuttle.springbootwebtutorial.dto.Employeedto;
import com.codingshuttle.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<Employeedto> getEmployeeById(Long id) {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id).get();
//        //ModelMapper modelMapper=new ModelMapper();
//        //soruce,destination
//        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,Employeedto.class));
   return  employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,Employeedto.class));

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
    public boolean employeeexistbyid(Long employeeID)
    {
        return employeeRepository.existsById(employeeID);
    }

    public boolean deleteEmployeeById(Long employeeID) {
boolean exists=employeeexistbyid(employeeID);
if(!exists) return false;

employeeRepository.deleteById(employeeID);
return  true;
    }

    public Employeedto updatePartialEmployeeById(Long employeeID, Map<String,Object> updates) {
        boolean exists=employeeexistbyid(employeeID);
        if(!exists)
        return null;
    EmployeeEntity employeeEntity=employeeRepository.findById(employeeID).get();
updates.forEach((field,value)->
{

 Field fieldtobeupdated=ReflectionUtils.findField(EmployeeEntity.class,field);
 fieldtobeupdated.setAccessible(true);
 ReflectionUtils.setField(fieldtobeupdated,employeeEntity,value);
});
return modelMapper.map(employeeRepository.save(employeeEntity),Employeedto.class);
    }}