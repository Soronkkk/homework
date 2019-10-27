package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * Генерирует отчет для текущего отдела.
     */
    @Deprecated
    void generateReport(Department department);

    /**
     * Возвращает отдел по названию.
     *
     * @param name название отдела.
     * @return отдел.
     */
    Department findByName(String name);

    /**
     * Возвращает отдел по описанию.
     *
     * @param description описание отдела.
     * @return отдел.
     */
    Department findByDescription(String description);

    /**
     * Возвращает список всех отделов.
     *
     * @return список отделов.
     */
    List<Department> findAll();

    /**
     * Удаляет отдел по идентификатору.
     *
     * @param id идентификатор отдела.
     * @return
     */
    boolean deleteById(Long id);


    /**
     * Сохраняет отдел.
     *
     * @param department отдел.
     * @return сохраненный отдел.
     */
    Department save(Department department);


}
