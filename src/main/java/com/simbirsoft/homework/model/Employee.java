package com.simbirsoft.homework.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractIdEntity {

    /**
     * Имя сотрудника.
     */
    @NotBlank(message = "Name is mandatory")
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Фамилия сотрудника.
     */
    @NotBlank(message = "Surname is mandatory")
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    /**
     * Заработная плата.
     */
    @Column(name = "SALARY", nullable = false)
    private int salary;

    /**
     * Должность.
     */
    @NotBlank(message = "Job title is mandatory")
    @Column(name = "JOB_TITLE", nullable = false)
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

    public Employee(Long id, String name, String surname, int salary, String jobTitle) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.jobTitle = jobTitle;
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

}
