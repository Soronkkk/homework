package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.EmployeeDataService;
import com.simbirsoft.homework.services.impl.EmployeeService;
import com.simbirsoft.homework.services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class EmployeeController {

    /*
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    */


    @Autowired
    EmployeeDataService employeeDataService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employeeDataService.save(employee);
        return getAllEmployee();
    }



    @GetMapping("/getEmployees")
    public ResponseEntity<Object> getAllEmployee() {
        List<Employee> employees = new ArrayList<>((Collection<? extends Employee>) employeeDataService.findAll());
        ServiceResponse<List<Employee>> serviceResponse = new ServiceResponse<>("success", employees);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    //fixme сделать так, чтобы при неуказанном id не добавлялся новый элемент в бд
    @PutMapping("/updateEmployee")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        employeeDataService.save(employee);
        return getAllEmployee();
    }

    /*
    @Deprecated
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
        employeeService.removeEmployee(id);
        return getAllEmployee();
    }*/

    @DeleteMapping("/deleteEmployee/{id}")
    @ResponseBody
    public boolean deleteEmployee(@PathVariable long id) {
        this.employeeDataService.deleteById(id);
        return true;
    }

}
