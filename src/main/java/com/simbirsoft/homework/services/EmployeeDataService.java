package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDataService {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public Iterable<Employee> findAll(){
        return employeeCrudRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        employeeCrudRepository.deleteById(id);
    }

    @Transactional
    public Employee save(Employee employee){
        return employeeCrudRepository.save(employee);
    }

}