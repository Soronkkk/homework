package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.EmployeeServiceImpl;
import com.simbirsoft.homework.data.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Employee> employees = new ArrayList<>((Collection<? extends Employee>) employeeServiceImpl.findAll());
        Response<List<Employee>> response = new Response<>("success", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        if (employee.getId() == null) {
            employeeServiceImpl.save(employee);
        } else {
            return ResponseEntity.badRequest().body(employee);
        }
        return getObjectResponseEntity();
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() != null && employee.getId() > 0) {
            employeeServiceImpl.save(employee);
        } else {
            return ResponseEntity.badRequest().body(employee);
        }
        return getObjectResponseEntity();
    }

    @DeleteMapping("/employees/{id}")
    @ResponseBody
    public boolean deleteEmployee(@PathVariable long id) {
        this.employeeServiceImpl.deleteById(id);
        return true;
    }

}
