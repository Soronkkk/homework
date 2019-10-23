package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.DepartmentService;
import com.simbirsoft.homework.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Employee> employees = new ArrayList<>(employeeService.findAll());
        Response<List<Employee>> response = new Response<>("success", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (employee.getId() == null) {
                employee.setCreatedBy("ADMIN");
                employee.setCreatedWhen(LocalDate.now());

                employeeService.save(employee);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(employee);
            }
        }
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (employee.getId() != null && employee.getId() > 0) {
                employee.setCreatedBy("ADMIN");
                employee.setCreatedWhen(LocalDate.now());

                employeeService.save(employee);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(employee);
            }
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
        boolean isRemoved = employeeService.deleteById(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
