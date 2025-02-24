package com.example.UC5_EmployeePayrollApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    // In-memory Employee List
    private final List<Employee> employeeList = new ArrayList<>();

    // Atomic ID generator (to simulate DB auto-increment)
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Store Employee (Add)
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        logger.info("Adding new employee: {}", employeeDTO.getName());

        Employee employee = new Employee();
        employee.setId(idGenerator.getAndIncrement()); // Simulating DB ID
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setEmail(employeeDTO.getEmail());

        employeeList.add(employee);

        logger.info("Employee added successfully: {}", employee.getId());

        return new EmployeeDTO(employee.getName(), employee.getSalary(), employee.getEmail());
    }

    // Get All Employees
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Fetching all employees...");
        return employeeList.stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary(), emp.getEmail()))
                .collect(Collectors.toList());
    }

    // Get Employee By ID
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary(), emp.getEmail()))
                .findFirst();
    }

    // Update Employee
    public Optional<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        logger.info("Updating employee with ID: {}", id);

        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                employee.setEmail(employeeDTO.getEmail());
                logger.info("Employee updated: {}", id);
                return Optional.of(new EmployeeDTO(employee.getName(), employee.getSalary(), employee.getEmail()));
            }
        }

        logger.warn("Employee with ID {} not found!", id);
        return Optional.empty();
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
