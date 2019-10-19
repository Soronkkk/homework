package com.simbirsoft.homework.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractCreatedInfo {

    /**
     * Имя сотрудника.
     */
    @NotBlank(message = "{error.employee.name}")
    @Size(min = 2, max = 30)
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Фамилия сотрудника.
     */
    @NotBlank(message = "{error.employee.surname}")
    @Length(max = 1024, message = "Max length")
    @Column(name = "surname", nullable = false)
    private String surname;

    /**
     * Название отдела, в котором работает сотрудник.
     */
    @NotBlank(message = "{error.employee.departmentName}")
    @Length(max = 2048, message = "Max length")
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    /**
     * Заработная плата.
     */
    @Min(value = 0, message = "{error.employee.salary}")
    @Column(name = "salary", nullable = false)
    private int salary;

    /**
     * Должность.
     */
    @NotBlank(message = "{error.employee.jobTitle}")
    @Length(max = 1024, message = "Max length")
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    /**
     * Связь многие к одному.
     * Сотрудник принадлежит к одному отделу.
     */
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "ID")
    private Department department;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, int salary, String jobTitle, String departmentName, String createdBy, LocalDate createdWhen) {
        super(id, createdBy, createdWhen);
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.departmentName = departmentName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
