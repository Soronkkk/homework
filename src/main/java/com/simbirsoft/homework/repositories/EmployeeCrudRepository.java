package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeCrudRepository extends JpaRepository<Employee, Long> {
    /**
     * Выполняет поиск сотрудника по его имени.
     * 
     * @param name имя сотрудника
     * @return
     */
    Optional<Employee> findByName(String name);
}
