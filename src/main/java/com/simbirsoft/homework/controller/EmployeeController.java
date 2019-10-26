package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.data.Response;
import com.simbirsoft.homework.dto.EmployeeDTO;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.services.EmployeeService;
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
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Добавляет сотрудника.
     *
     * @param employeeDTO   dto сотрудника.
     * @param bindingResult обязательный результат.
     * @return responseEntity.
     */
    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Employee employee = convertToEntity(employeeDTO);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (employee.getId() == null) {
                employeeService.save(employee);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(employee);
            }
        }
    }

    /**
     * Обновляет отдел.
     *
     * @param employeeDTO   dto сотрудника.
     * @param bindingResult обязательный результат.
     * @return responseEntity.
     */
    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Employee employee = convertToEntity(employeeDTO);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerMapErrors.getErrors(bindingResult);
            return ResponseEntity.ok(errors);
        } else {
            if (employeeDTO.getId() != null) {
                employeeService.save(employee);
                return getObjectResponseEntity();
            } else {
                return ResponseEntity.badRequest().body(employee);
            }
        }
    }

    /**
     * Удаляет сотрудника по передаваемому идентификатору.
     *
     * @param id идентификатор.
     * @return responseEntity с кодом статуса 200 или 404.
     */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
        boolean isRemoved = employeeService.deleteById(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Конвертирует dto в сущность.
     *
     * @param employeeDTO dto сущности.
     * @return сущность.
     */
    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        return employee;
    }

    private ResponseEntity<Object> getObjectResponseEntity() {
        List<Employee> employees = new ArrayList<>(employeeService.findAll());
        Response<List<Employee>> response = new Response<>("success", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
