package com.simbirsoft.homework.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractIdEntity {

    /**
     * Название отдела.
     */
//    @NotBlank(message = "Name is mandatory")
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Описание отдела.
     */
//    @NotBlank(message = "Description is mandatory")
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;


    /**
     * Связь один ко многим.
     * В отделе хранится список сотрудников.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String name, String description) {
        super(id);
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

}
