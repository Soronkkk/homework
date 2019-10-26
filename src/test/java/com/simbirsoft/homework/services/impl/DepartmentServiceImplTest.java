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
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        Mockito.when(departmentJpaRepository.findByDescription(Mockito.anyString())).thenReturn(department);
        Mockito.when(departmentJpaRepository.findAll()).thenReturn(departments);
    }


    @Test
    public void findByDescription() {
        String description = "desc";
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        departmentService.save(department);
        Assert.assertEquals(departmentJpaRepository.findByDescription(description), departmentService.findByDescription(description));
    }

    @Test
    public void findAll() {
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        departmentService.save(department);
        Assert.assertArrayEquals(departmentJpaRepository.findAll().toArray(), departmentService.findAll().toArray());
    }

    @Test
    public void save() {
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        departmentService.save(department);
        Assert.assertEquals(departmentJpaRepository.findAll().size() + 1, 2);
    }

    @Test
    public void findByName() {
        String name = "departmentName1";
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        departmentService.save(department);
        Assert.assertEquals(departmentJpaRepository.findByName(name), departmentService.findByName(name));
    }
}