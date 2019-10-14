package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * Возвращает отдел по описанию.
     *
     * @param description описание отдела.
     * @return отдел.
     */
    public Department findByDescription(String description);

    /**
     * Возвращает список всех отделов.
     *
     * @return список отделов.
     */
    public List<Department> findAll();

    /**
     * Удаляет отдел по идентификатору.
     *
     * @param id идентификатор отдела.
     */
    public void deleteById(Long id);


    /**
     * Сохраняет отдел.
     *
     * @param department отдел.
     * @return сохраненный отдел.
     */
    public Department save(Department department);

}
