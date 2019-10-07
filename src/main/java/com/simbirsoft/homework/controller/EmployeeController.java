package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.service.EmployeeService;
import com.simbirsoft.homework.service.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return getAllEmployee();
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> getAllEmployee() {
        ServiceResponse<List<Employee>> serviceResponse = new ServiceResponse<>("success", employeeService.findAll());
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return getAllEmployee();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
        employeeService.removeEmployee(id);
        return getAllEmployee();
    }


}
