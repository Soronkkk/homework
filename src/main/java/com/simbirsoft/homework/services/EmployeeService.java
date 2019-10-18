package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Возвращает список сотрудников с указанной заработной платой.
     *
     * @param salary заработная плата сотрудника.
     * @return список сотрудников.
     */
    List<Employee> findBySalary(int salary);

    /**
     * Возвращает список сотрудников с указанной должностью.
     *
     * @param jobTitle должность сотрудника.
     * @return список сотрудников.
     */
    List<Employee> findByJobTitle(String jobTitle);

    /**
     * Возвращает список сотрудников с указанным именем.
     *
     * @param name имя сотрудника.
     * @return список сотрудников.
     */
    List<Employee> findByName(String name);

    /**
     * Возвращает список всех сотрудников.
     *
     * @return список сотрудников
     */
    List<Employee> findAll();

    /**
     * Удаляет сотрудника по идентификатору.
     *
     * @param id индентификатор
     */
    void deleteById(Long id);

    /**
     * Сохраняет сотрудника.
     *
     * @param employee сотрудник
     * @return сохраненный сотрудник
     */
    Employee save(Employee employee);

}
