package com.simbirsoft.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractIdEntity {

    /**
     * Имя сотрудника.
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Фамилия сотрудника.
     */
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
    @Column(name = "JOB_TITLE", nullable = false)
    private String jobTitle;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, int salary, String jobTitle) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.jobTitle = jobTitle;
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
