package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import com.simbirsoft.homework.services.EmployeeService;
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

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private DepartmentJpaRepository departmentJpaRepository;

    @Mock
    private EmployeeJpaRepository employeeJpaRepository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Before
    public void init() throws Exception {
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());

        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(employeeJpaRepository.findAllBySalary(Mockito.anyInt())).thenReturn(employees);
        Mockito.when(employeeJpaRepository.findByName(Mockito.anyString())).thenReturn(employees);
        Mockito.when(employeeJpaRepository.findByJobTitle(Mockito.anyString())).thenReturn(employees);
        Mockito.when(employeeJpaRepository.findAll()).thenReturn(employees);
        Mockito.when(employeeJpaRepository.findAllByDepartmentName(Mockito.anyString())).thenReturn(employees);

    }

    @Test
    public void findAllByDepartmentName() {
        String departmentName = "departmentName1";
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findAllByDepartmentName("jobTitle").toArray(), employeeService.findAllByDepartmentName(departmentName).toArray());
    }

    @Test
    public void findAllByContainsDepartmentName(){
        String departmentName = "department";
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findAllByDepartmentName("departmentName1").toArray(), employeeService.findAllByContainsDepartmentName(departmentName).toArray());

    }

    @Test
    public void findAllByJobTitle() {
        String jobTitle = "jobTitle";
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findByJobTitle("jobTitle").toArray(), employeeService.findByJobTitle(jobTitle).toArray());
    }

    @Test
    public void deleteById() {
        Long id = 1L;
        employeeService.save(new Employee());
        employeeService.deleteById(id);
        Mockito.verify(employeeJpaRepository).deleteById(id);
    }


    @Test
    public void save() {
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        int newSize = 2;
        Assert.assertEquals(employeeJpaRepository.findAll().size() + 1, newSize);
    }

    @Test
    public void findAllBySalary() {
        int salary = 1;
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        Department department = new Department(1L, "departmentName1", "description", "createdBy", LocalDate.now());
        departmentJpaRepository.save(department);
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findAllBySalary(1).toArray(), employeeService.findAllBySalary(salary).toArray());
    }

    @Test
    public void findAllByContainsJobTitle() {
        String jobTitle = "jobTitle1432";
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findByJobTitle("jobTitle").toArray(), employeeService.findAllByContainsJobTitle(jobTitle).toArray());
    }

    @Test
    public void findByName() {
        String name = "name1";
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findByName("name1").toArray(), employeeService.findByName(name).toArray());
    }

    @Test
    public void findAll() {
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employee.setDepartment(departmentJpaRepository.findByName(employee.getDepartmentName()));
        employeeService.save(employee);
        Assert.assertArrayEquals(employeeJpaRepository.findAll().toArray(), employeeService.findAll().toArray());
    }


}