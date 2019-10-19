package com.simbirsoft.homework.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractCreatedInfo {

    /**
     * Название отдела.
     */
    @NotBlank(message = "{error.department.name}")
    @Length(max = 1024, message = "Max length")
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание отдела.
     */
    @NotBlank(message = "{error.department.description}")
    @Length(max = 1024, message = "Max length")
    @Column(name = "description", nullable = false)
    private String description;


    /**
     * Связь один ко многим.
     * В отделе хранится список сотрудников.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    /**
     * Связь один ко многим.
     * В отделе хранится список отчетов.
     */
    @OneToMany(mappedBy = "department")
    private List<DepartmentReport> departmentReports;

    public Department() {
    }

    public Department(Long id, String name, String description, String createdBy ,LocalDate createdWhen) {
        super(id, createdBy, createdWhen);
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Employee> getEmployees() {
        return employees;
    }
}
