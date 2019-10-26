package com.simbirsoft.homework.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles
public class EmployeeControllerTest {
    private static final ObjectMapper om = new ObjectMapper();

    // TODO: 26.10.2019 Инициализировать 29.50
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeJpaRepository employeeJpaRepository;


    @Before
    public void init() throws Exception {
        Employee employee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "createdBy1", LocalDate.now());
        employeeJpaRepository.save(employee);
    }


    @Test
    public void deleteEmployeeIsOk() throws Exception {
        doNothing().when(employeeJpaRepository).deleteById(1L);
        mockMvc.perform(delete("employees/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEmployee() {
        doNothing().when(employeeJpaRepository).deleteById(1L);
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<String> responseEntity = restTemplate.exchange("/employees/1", HttpMethod.DELETE, entity, String.class);
        Assert.assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }


    @Test
    public void updateEmployee() throws Exception {
        Employee updEmployee = new Employee(1L, "name1", "surname1", 1, "jobTitle", "departmentName1", "ADMIN", LocalDate.now());
        when(employeeJpaRepository.save(any(Employee.class))).thenReturn(updEmployee);

        mockMvc.perform(put("/employees")
                .content(om.writeValueAsString(updEmployee))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.createdBy", is("ADMIN")))
                .andExpect(jsonPath("$.createdWhen", is(LocalDate.now())))
                .andExpect(jsonPath("$.name", is("name1")))
                .andExpect(jsonPath("$.surname", is("surname1")))
                .andExpect(jsonPath("$.salary", is(1)))
                .andExpect(jsonPath("$.jobTitle", is("jobTitle")))
                .andExpect(jsonPath("$.departmentName", is("departmentName1")));
    }

    @Test
    public void addEmployee() throws Exception {
        Employee newEmployee = new Employee(2L, "name2", "surname2", 1, "jobTitle", "departmentName2", "ADMIN", LocalDate.now());
        when(employeeJpaRepository.save(any(Employee.class))).thenReturn(newEmployee);

        mockMvc.perform(post("/employees")
                .content(om.writeValueAsString(newEmployee))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.createdBy", is("ADMIN")))
                .andExpect(jsonPath("$.createdWhen", is(LocalDate.now())))
                .andExpect(jsonPath("$.name", is("name1")))
                .andExpect(jsonPath("$.surname", is("surname1")))
                .andExpect(jsonPath("$.salary", is(1)))
                .andExpect(jsonPath("$.jobTitle", is("jobTitle")))
                .andExpect(jsonPath("$.departmentName", is("departmentName1")));
        verify(employeeJpaRepository, times(1)).save(any(Employee.class));
    }


}






