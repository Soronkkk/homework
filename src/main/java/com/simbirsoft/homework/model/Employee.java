package com.simbirsoft.homework.model;


public class Employee {

    private int id;
    private String name;
    private String surname;
    private int salary;
    private String jobTitle;

    public Employee() {
    }

    public Employee(int id, String name, String surname, int salary, String jobTitle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
