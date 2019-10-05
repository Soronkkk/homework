package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public String getEmployeeById(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", this.employeeService.findEmployeeById(id));

        return "employeedata";
    }

    @GetMapping("/employees")
    public ModelAndView getEmployees(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        if(employee.getId()==0){
            this.employeeService.addEmployee(employee);
        }else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employees";
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public Boolean removeEmployee(@PathVariable("id") Long id){
        this.employeeService.removeEmployee(id);
        return true;
    }

    @PutMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", this.employeeService.findEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.findAll());

        return "employees";
    }
}
