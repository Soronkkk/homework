package com.simbirsoft.homework.services;

import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.services.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;

    @Transactional
    public List<Department> findAll() {
        return departmentJpaRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        departmentJpaRepository.deleteById(id);
    }

    @Transactional
    public Department save(Department department) {
        return departmentJpaRepository.save(department);
    }

    @Transactional
    public Department findByName(String name){
        return departmentJpaRepository.findByName(name);
    }

}
