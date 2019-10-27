package com.simbirsoft.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles
public class DepartmentControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private DepartmentJpaRepository departmentJpaRepository;


    @Before
    public void init() throws Exception {
        Department department = new Department(1L, "departmentName1", "description", "ADMIN", LocalDate.now());
        departmentJpaRepository.save(department);
        when(departmentJpaRepository.findById(1L)).thenReturn(Optional.of(department));

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void deleteDepartmentIsOk() throws Exception {
        doNothing().when(departmentJpaRepository).deleteById(1L);
        mockMvc.perform(delete("/departments/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteDepartment() {
        doNothing().when(departmentJpaRepository).deleteById(1L);
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<String> responseEntity = restTemplate.exchange("/departments/1", HttpMethod.DELETE, entity, String.class);
        Assert.assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }


    @Test
    public void updateDepartment() throws Exception {
        Department updDepartment = new Department(1L, "departmentName1", "description", "ADMIN", LocalDate.now());
        when(departmentJpaRepository.save(any(Department.class))).thenReturn(updDepartment);

        mockMvc.perform(put("/departments")
                .content(om.writeValueAsString(updDepartment))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.createdBy", is("ADMIN")))
                .andExpect(jsonPath("$.createdWhen", is(LocalDate.now())))
                .andExpect(jsonPath("$.name", is("departmentName1")))
                .andExpect(jsonPath("$.description", is("description")));

    }


    @Test
    public void addDepartment() throws Exception {
        Department newDepartment = new Department(2L, "departmentName2", "description", "ADMIN", LocalDate.now());
        when(departmentJpaRepository.save(any(Department.class))).thenReturn(newDepartment);

        mockMvc.perform(post("/department")
                .content(om.writeValueAsString(newDepartment))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.createdBy", is("ADMIN")))
                .andExpect(jsonPath("$.createdWhen", is(LocalDate.now())))
                .andExpect(jsonPath("$.name", is("departmentName2")))
                .andExpect(jsonPath("$.description", is("description")));
        verify(departmentJpaRepository, times(1)).save(any(Department.class));
    }

}