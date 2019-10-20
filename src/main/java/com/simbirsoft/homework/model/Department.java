package com.simbirsoft.homework.model;


import com.simbirsoft.homework.repositories.EmployeeJpaRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractCreatedInfo {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", employees=").append(employees);
        sb.append(", departmentReports=").append(departmentReports);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Department that = (Department) object;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(employees, that.employees) &&
                Objects.equals(departmentReports, that.departmentReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, employees, departmentReports);
    }
}
