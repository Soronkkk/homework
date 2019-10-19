package com.simbirsoft.homework.services.impl;

import com.simbirsoft.homework.model.Department;
import com.simbirsoft.homework.model.DepartmentReport;
import com.simbirsoft.homework.model.Employee;
import com.simbirsoft.homework.repositories.DepartmentJpaRepository;
import com.simbirsoft.homework.repositories.DepartmentReportJpaRepository;
import com.simbirsoft.homework.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;
    @Autowired
    private DepartmentReportJpaRepository departmentReportJpaRepository;

    @Transactional
    public void generateReport(Department department) {
        List<Employee> employees = department.getEmployees();
        int employeeCount = employees.size();
        double averageEmployee = employees.stream().mapToDouble(Employee::getSalary).sum() / employeeCount;
        DepartmentReport departmentReport = new DepartmentReport();
        departmentReport.setEmployeesCount(employeeCount);
        departmentReport.setAverageSalary(averageEmployee);
        departmentReport.setDepartment(department);
        departmentReportJpaRepository.save(departmentReport);
    }

    @Transactional
    public Department findByDescription(String description) {
        return departmentJpaRepository.findByDescription(description);
    }

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
    public Department findByName(String name) {
        return departmentJpaRepository.findByName(name);
    }

}
