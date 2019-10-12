package com.simbirsoft.homework.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractIdEntity {

    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;


    public AbstractIdEntity() {
    }

    public AbstractIdEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
