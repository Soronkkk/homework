package com.simbirsoft.homework.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractIdEntity {

    /**
     * Описание отдела.
     */
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    /**
     * Название отдела.
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Связь один ко многим.
     * В отделе хранится список сотрудников.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

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
