package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
    /**
     * Выполняет поиск отдела по имени.
     *
     * @param name название отдела
     * @return отдел
     */
    Department findByName(String name);
}
