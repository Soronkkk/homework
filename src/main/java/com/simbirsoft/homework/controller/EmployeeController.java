package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.impl.DepartmentServiceImpl;
import com.simbirsoft.homework.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Employee> employees = new ArrayList<>(employeeServiceImpl.findAll());
        Response<List<Employee>> response = new Response<>("success", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees/{department}")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee, @PathVariable String department) {
        if (employee.getId() == null) {
            employee.setDepartment(departmentServiceImpl.findByName(department));
            employeeServiceImpl.save(employee);
        }
        return getObjectResponseEntity();
    }

    @PutMapping("/employees/{department}")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable String department) {
        if (employee.getId() != null && employee.getId() > 0) {
            employee.setDepartment(departmentServiceImpl.findByName(department));
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
