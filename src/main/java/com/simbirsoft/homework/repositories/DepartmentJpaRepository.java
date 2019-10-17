package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
    /**
     * Выполняет поиск отдела по имени.
     *
     * @param name название отдела.
     * @return отдел.
     */
    Department findByName(String name);

    /**
     * Выполняет поиск отдела по его описанию.
     *
     * @param description описание отдела.
     * @return отдел.
     */
    @Query("select d from Department d where d.description = :description")
    Department findByDescription(String description);

}
