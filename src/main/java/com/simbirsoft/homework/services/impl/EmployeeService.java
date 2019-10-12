package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Возвращает список всех сотрудников.
     *
     * @return список сотрудников
     */
    public List<Employee> findAll();

    /**
     * Удаляет сотрудника по идентификатору.
     *
     * @param id индентификатор
     */
    public void deleteById(Long id);

    /**
     * Сохраняет созданного сотрудника.
     *
     * @param employee сотрудник
     * @return сохраненный сотрудник
     */
    public Employee save(Employee employee);

}
