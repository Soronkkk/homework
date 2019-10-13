package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO: 14.10.2019 В репозиториях описать методы как посредством @Query, так и посредством названия метода.
@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    /**
     * Выполняет поиск сотрудников по имени.
     *
     * @param name имя сотрудника
     * @return список сотрудников
     */
    List<Employee> findByName(String name);

}
