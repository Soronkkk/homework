package com.simbirsoft.homework.dto;

import java.util.Objects;

public class EmployeeDTO {

    private Long id;

    private String name;

    private String surname;

    private int salary;

    private String jobTitle;

    private String departmentName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) object;
        return salary == that.salary &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, salary, jobTitle, departmentName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", jobTitle='").append(jobTitle).append('\'');
        sb.append(", department_name='").append(departmentName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
