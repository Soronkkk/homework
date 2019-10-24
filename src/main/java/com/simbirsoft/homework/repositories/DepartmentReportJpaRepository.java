package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.DepartmentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentReportJpaRepository extends JpaRepository<DepartmentReport, Long> {
}
