package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Department> departments = new ArrayList<>(departmentService.findAll());
        Response<List<Department>> response = new Response<>("success", departments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/departments")
    public ResponseEntity<Object> addDepartment(@Valid @RequestBody Department department, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (department.getId() == null) {
                // FIXME: 19.10.2019 hardcode
                department.setCreatedBy("ADMIN");
                department.setCreatedWhen(LocalDate.now());

                departmentService.save(department);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    @PutMapping("/departments")
    public ResponseEntity<Object> updateDepartment(@Valid @RequestBody Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (department.getId() != null && department.getId() > 0) {
                // FIXME: 19.10.2019 hardcode
                department.setCreatedBy("ADMIN");
                department.setCreatedWhen(LocalDate.now());

                departmentService.save(department);
                return getObjectResponseEntity();

            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    @DeleteMapping("/departments/{id}")
    @ResponseBody
    public boolean deleteDepartment(@PathVariable long id) {
        this.departmentService.deleteById(id);
        return true;
    }

}
