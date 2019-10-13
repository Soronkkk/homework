package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.DepartmentServiceImpl;
import com.simbirsoft.homework.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// TODO: 14.10.2019  Добавить валидацию данных с фронта, использовать аннотацию @Valid.
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

    // TODO: 14.10.2019  дописать логику добавления сотрудника с отделом
    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee) {
        if (employee.getId() == null) {
            employee.setDepartment(departmentServiceImpl.findByName("Develop"));
            employeeServiceImpl.save(employee);
        } else {
            return ResponseEntity.badRequest().body(employee);
        }
        return getObjectResponseEntity();
    }

    // TODO: 14.10.2019  дописать логику обновления сотрудника с отделом
    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() != null && employee.getId() > 0) {
            employee.setDepartment(departmentServiceImpl.findByName("Develop"));
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
