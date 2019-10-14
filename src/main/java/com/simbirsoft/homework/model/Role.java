package com.simbirsoft.homework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role extends AbstractIdEntity {

    /**
     * Название роли.
     */
    @Column(name = "TITLE", nullable = false)
    private String title;

    public Role(Long id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
