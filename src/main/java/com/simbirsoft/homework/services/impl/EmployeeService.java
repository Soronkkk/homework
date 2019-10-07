package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Employee;

import java.util.List;

@Deprecated
public interface EmployeeService {
    public Employee findEmployeeById(Long id);

    public List<Employee> findAll();

    public void addEmployee(Employee employee);

    public void removeEmployee(Long id);

    public void updateEmployee(Employee employee);
}
