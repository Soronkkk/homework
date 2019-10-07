package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByName(String name);
}
