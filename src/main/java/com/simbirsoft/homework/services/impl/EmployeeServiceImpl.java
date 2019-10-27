package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.AbstractCreatedInfo;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import com.simbirsoft.homework.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;


    @Transactional
    public List<Employee> findAllByContainsJobTitle(String jobTitle) {
       return employeeJpaRepository.findAllByContainsJobTitle(jobTitle);
    }

    @Transactional
    public List<Employee> findAllByContainsDepartmentName(String departmentName) {
       return employeeJpaRepository.findAllByDepartmentName(departmentName);
    }


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
    public boolean deleteById(Long id) {
        employeeJpaRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Employee save(Employee employee) {
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        employee.setCreatedBy(auth.getName());
        employee.setCreatedWhen(AbstractCreatedInfo.DEFAULT_CREATED_WHEN);
        return employeeJpaRepository.save(employee);
    }

    @Transactional
    public List<Employee> findAllByDepartmentName(String departmentName) {
        return employeeJpaRepository.findAllByContainsDepartmentName(departmentName);
    }

}