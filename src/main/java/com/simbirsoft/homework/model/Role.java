package com.simbirsoft.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends AbstractCreatedInfo {

    /**
     * Название роли.
     */
    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

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
