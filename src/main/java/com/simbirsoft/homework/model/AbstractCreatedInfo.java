package com.simbirsoft.homework.model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractCreatedInfo {

    /**
     * Константа. Дефолтное значение поля createdBy.
     */
    private static final String DEFAULT_CREATED_BY = "GOD";

    /**
     * Константа. Дефолтное значение поля createdWhen.
     */
    private static final LocalDate DEFUALT_CREATED_WHEN = LocalDate.now();

    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    /**
     * Кем создано.
     */
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    /**
     * Когда создано.
     */
    @Column(name = "created_when", updatable = false, nullable = false)
    private LocalDate createdWhen;


    public AbstractCreatedInfo() {
    }

    public AbstractCreatedInfo(Long id) {
        this(id, DEFAULT_CREATED_BY, DEFUALT_CREATED_WHEN);
    }

    public AbstractCreatedInfo(Long id, String createdBy, LocalDate createdWhen) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdWhen = createdWhen;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(LocalDate createdWhen) {
        this.createdWhen = createdWhen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
