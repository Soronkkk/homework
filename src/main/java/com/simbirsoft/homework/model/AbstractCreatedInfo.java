package com.simbirsoft.homework.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractCreatedInfo {

    /**
     * Константа. Дефолтное значение поля createdBy.
     */
    public static final String DEFAULT_CREATED_BY = "GOD";

    /**
     * Константа. Дефолтное значение поля createdWhen.
     */
    public static final LocalDate DEFAULT_CREATED_WHEN = LocalDate.now();

    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0)
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
        this(id, DEFAULT_CREATED_BY, DEFAULT_CREATED_WHEN);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractCreatedInfo{");
        sb.append("id=").append(id);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", createdWhen=").append(createdWhen);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AbstractCreatedInfo that = (AbstractCreatedInfo) object;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdWhen, that.createdWhen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, createdWhen);
    }
}
