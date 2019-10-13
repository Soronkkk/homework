package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: 14.10.2019  В репозиториях описать методы как посредством @Query, так и посредством названия метода.
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
