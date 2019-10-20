package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.model.DepartmentReport;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.repositories.DepartmentReportJpaRepository;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import com.simbirsoft.homework.services.DepartmentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {


    @Mock
    private DepartmentJpaRepository departmentJpaRepository;

    @InjectMocks
    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Before
    public void init() throws Exception {


    }


    @Test
    public void findByDescription() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findByName() {
    }
}