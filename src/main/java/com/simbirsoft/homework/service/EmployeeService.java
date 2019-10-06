package com.simbirsoft.homework.service;

import com.simbirsoft.homework.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee findEmployeeById(Long id);

    public List<Employee> findAll();

    public void addEmployee(Employee employee);

    public void removeEmployee(Long id);

    public void updateEmployee(int id, Employee employee);
}
