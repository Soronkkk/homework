package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.dto.DepartmentDTO;
import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.services.DepartmentService;
import com.simbirsoft.homework.utils.ControllerMapErrors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Добавляет отдел.
     *
     * @param departmentDTO dto отдела.
     * @param bindingResult обязательный результат.
     * @return responseEntity.
     */
    @PostMapping("/departments")
    public ResponseEntity<Object> addDepartment(@Valid @RequestBody DepartmentDTO departmentDTO, BindingResult bindingResult) {
        Department department = convertToEntity(departmentDTO);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (departmentDTO.getId() == null) {
                departmentService.save(department);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    /**
     * Обновляет отдел.
     *
     * @param departmentDTO dto отдела.
     * @param bindingResult обязательный результат.
     * @return responseEntity.
     */
    @PutMapping("/departments")
    public ResponseEntity<Object> updateDepartment(@Valid @RequestBody DepartmentDTO departmentDTO, BindingResult bindingResult) {
        Department department = convertToEntity(departmentDTO);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (departmentDTO.getId() != null) {
                departmentService.save(department);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(department);
            }
        }
    }

    /**
     * Удаляет отдел по передаваемому идентификатору.
     *
     * @param id идентификатор.
     * @return responseEntity с кодом статуса 200 или 404.
     */
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable long id) {
        boolean isRemoved = departmentService.deleteById(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Конвертирует dto в сущность.
     *
     * @param departmentDTO dto сущности.
     * @return сущность.
     */
    private Department convertToEntity(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        return department;
    }

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Department> departments = new ArrayList<>(departmentService.findAll());
        Response<List<Department>> response = new Response<>("success", departments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
