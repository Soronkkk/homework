package com.simbirsoft.homework.service.impl;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employees;


    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Adams", 15000, "Sales advisor"));
        employees.add(new Employee(2, "John", "Adams", 60000, "Store manager"));
        employees.add(new Employee(3, "John", "Adams", 40000, "Core manager"));
        employees.add(new Employee(4, "John", "Adams", 35000, "Department manager"));
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                result = employee;
            }
        }
        if (result != null) {
            return result;
        }
        return new Employee();
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Long id) {
        employees.remove(id);
    }

    @Override
    public void updateEmployee(Employee updEmployee) {
        for (Employee employee : employees) {
            if (employee.equals(updEmployee)) {
                employee = updEmployee;
            }
        }
    }


}
