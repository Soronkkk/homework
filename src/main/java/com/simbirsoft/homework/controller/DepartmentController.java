package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Department> departments = new ArrayList<>(departmentServiceImpl.findAll());
        Response<List<Department>> response = new Response<>("success", departments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/departments")
    public ResponseEntity<Object> addDepartment(@Valid @RequestBody Department department) {
        if (department.getId() == null) {
            departmentServiceImpl.save(department);
        } else {
            return ResponseEntity.badRequest().body(department);
        }
        return getObjectResponseEntity();
    }

    @PutMapping("/departments")
    public ResponseEntity<Object> updateDepartment(@Valid @RequestBody Department department) {
        if (department.getId() != null && department.getId() > 0) {
            departmentServiceImpl.save(department);
        } else {
            return ResponseEntity.badRequest().body(department);
        }
        return getObjectResponseEntity();
    }

    @DeleteMapping("/departments/{id}")
    @ResponseBody
    public boolean deleteDepartment(@PathVariable long id) {
        this.departmentServiceImpl.deleteById(id);
        return true;
    }

}
