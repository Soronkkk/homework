package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.services.impl.DepartmentServiceImpl;
import com.simbirsoft.homework.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    /**
     * Возвращает модель с данными для отображения на странице.
     *
     * @return модель с данными сотрудников и отделов.
     */
    @GetMapping("/")
    public ModelAndView employeesPage(
            Authentication authentication
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeServiceImpl.findAll());
        modelAndView.addObject("departments", departmentServiceImpl.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
