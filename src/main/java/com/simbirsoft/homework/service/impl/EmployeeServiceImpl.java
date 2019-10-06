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


    //todo перейти на работу с БД
    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "John", "Adams", 15000, "Sales advisor"));
        employees.add(new Employee(2L, "John", "Adams", 60000, "Store manager"));
        employees.add(new Employee(3L, "John", "Adams", 40000, "Core manager"));
        employees.add(new Employee(4L, "John", "Adams", 35000, "Department manager"));
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

    //fixme переделать
    @Override
    public void addEmployee(Employee employee) {
        for (int i = 0; i <employees.size() ; i++) {
            if(employees.get(i).getId() == employee.getId()){
                return;
            }
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Long id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                return;
            }
        }
    }

    @Override
    public void updateEmployee(Employee updEmployee) {
        Employee employee;
        for (int i = 0; i < employees.size(); i++) {
            employee = employees.get(i);
            if (employee.getId() == updEmployee.getId()) {
                employees.set(i, updEmployee);
                return;
            }
        }

    }

}
