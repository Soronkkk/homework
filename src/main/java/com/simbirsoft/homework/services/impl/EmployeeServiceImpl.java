package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import com.simbirsoft.homework.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;

    @Transactional
    public List<Employee> findAllBySalary(int salary) {
        return employeeJpaRepository.findAllBySalary(salary);
    }

    @Transactional
    public List<Employee> findByJobTitle(String jobTitle) {
        return employeeJpaRepository.findByJobTitle(jobTitle);
    }

    @Transactional
    public List<Employee> findByName(String name) {
        return employeeJpaRepository.findByName(name);
    }

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
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        return employeeJpaRepository.save(employee);
    }

}