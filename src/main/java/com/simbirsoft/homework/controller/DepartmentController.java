package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.model.AbstractCreatedInfo;
import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.services.DepartmentService;
import com.simbirsoft.homework.utils.ControllerMapErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    // TODO: 26.10.2019 принимать dto
    @PostMapping("/departments")
    public ResponseEntity<Object> addDepartment(@Valid @RequestBody Department department, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (department.getId() == null) {
                // TODO: 26.10.2019 RequestContextHolder
                department.setCreatedBy(AbstractCreatedInfo.DEFAULT_CREATED_BY);
                department.setCreatedWhen(AbstractCreatedInfo.DEFAULT_CREATED_WHEN);

                departmentService.save(department);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    // TODO: 26.10.2019 принимать dto
    @PutMapping("/departments")
    public ResponseEntity<Object> updateDepartment(@Valid @RequestBody Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (department.getId() != null) {

                // TODO: 26.10.2019 RequestContextHolder
                department.setCreatedBy(AbstractCreatedInfo.DEFAULT_CREATED_BY);
                department.setCreatedWhen(AbstractCreatedInfo.DEFAULT_CREATED_WHEN);

                departmentService.save(department);
                return getObjectResponseEntity();

            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable long id) {
        boolean isRemoved = departmentService.deleteById(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Department> departments = new ArrayList<>(departmentService.findAll());
        Response<List<Department>> response = new Response<>("success", departments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
