package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    /**
     * Выполняет поиск сотрудников по имени.
     *
     * @param name имя сотрудника
     * @return список сотрудников
     */
    List<Employee> findByName(String name);

    /**
     * Выполняет поиск сотрудников по должности.
     *
     * @param jobTitle должность сотрудника.
     * @return сотрудники.
     */
    @Query("select e from Employee e where e.jobTitle = :jobTitle")
    List<Employee> findByJobTitle(String jobTitle);

    /**
     * Выполняет поиск сотрудников по заработной плате.
     *
     * @param salary заработная плата.
     * @return сотрудники.
     */
    @Query("select e from  Employee e where e.salary = :salary")
    List<Employee> findAllBySalary(int salary);
}
