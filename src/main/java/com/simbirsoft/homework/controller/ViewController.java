package com.simbirsoft.homework.controller;

import com.simbirsoft.homework.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class ViewController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/")
    public ModelAndView homePage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeServiceImpl.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
