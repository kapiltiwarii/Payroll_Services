package com.example.UC4_EmployeePayrollApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    // Business Logic: Add Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        logger.info("Adding new employee: {}", employeeDTO.getName());

        // Creating Model from DTO
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setEmail(employeeDTO.getEmail());

        // Saving Employee
        Employee savedEmployee = repository.save(employee);

        logger.info("Employee added successfully: {}", savedEmployee.getId());

        // Returning DTO
        return new EmployeeDTO(savedEmployee.getName(), savedEmployee.getSalary(), savedEmployee.getEmail());
    }

    // Business Logic: Get All Employees
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Fetching all employees...");

        List<EmployeeDTO> employees = repository.findAll().stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary(), emp.getEmail()))
                .collect(Collectors.toList());

        logger.info("Total employees found: {}", employees.size());

        return employees;
    }
}
