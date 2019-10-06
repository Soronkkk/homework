package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.service.EmployeeService;
import com.simbirsoft.homework.service.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        ServiceResponse<Employee> serviceResponse = new ServiceResponse<>("success", employee);
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> getAllEmployee(){
        ServiceResponse<List<Employee>> serviceResponse = new ServiceResponse<>("success", employeeService.findAll());
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

//    @PostMapping("/employees/add")
//    public String addEmployee(@ModelAttribute("employee") Employee employee){
//        if(employee.getId()==0){
//            this.employeeService.addEmployee(employee);
//        }else {
//            employeeService.updateEmployee(employee);
//        }
//        return "redirect:/employees";
//    }


//    @DeleteMapping("/remove/{id}")
//    public String removeEmployee(@PathVariable("id") Long id){
//        this.employeeService.removeEmployee(id);
//        return "employees";
//    }
//
//    @PutMapping("/edit/{id}")
//    public String editEmployee(@PathVariable("id") Long id, Model model){
//        model.addAttribute("employee", this.employeeService.findEmployeeById(id));
//        model.addAttribute("listEmployees", this.employeeService.findAll());
//
//        return "employees";
//    }
}
