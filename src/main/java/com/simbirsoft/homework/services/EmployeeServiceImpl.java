package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import com.simbirsoft.homework.services.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;


    @Transactional
    public List<Employee> findAll() {
        return employeeJpaRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        employeeJpaRepository.deleteById(id);
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    public List<Employee> findByName(String name){
        return  employeeJpaRepository.findByName(name);
    }

}