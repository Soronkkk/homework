package com.simbirsoft.homework.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Deprecated
@Entity
@Table(name = "DEPARTMENT_REPORT")
public class DepartmentReport extends AbstractCreatedInfo {


    /**
     * Количество сотрудников в отделе.
     */
    @Column(name = "employees_count")
    private int employeesCount;

    /**
     * Средняя заработная плата отдела.
     */
    @Column(name = "average_salary")
    private double averageSalary;

    /**
     * Связь многие к одному.
     * Отчет принадлежит одному отделу.
     */
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "ID")
    private Department department;

    public DepartmentReport() {

    }

    public DepartmentReport(Long id, int employeesCount, double averageSalary, String createdBy, LocalDate createdWhen) {
        super(id, createdBy, createdWhen);
        this.employeesCount = employeesCount;
        this.averageSalary = averageSalary;
    }


    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DepartmentReport{");
        sb.append("employeesCount=").append(employeesCount);
        sb.append(", averageSalary=").append(averageSalary);
        sb.append(", department=").append(department);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DepartmentReport that = (DepartmentReport) object;
        return employeesCount == that.employeesCount &&
                Double.compare(that.averageSalary, averageSalary) == 0 &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeesCount, averageSalary, department);
    }
}
