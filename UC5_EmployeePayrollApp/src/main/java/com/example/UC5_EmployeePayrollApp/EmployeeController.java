package com.example.UC5_EmployeePayrollApp;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        logger.info("Received request to add employee: {}", employeeDTO.getEmail());
        return employeeService.addEmployee(employeeDTO);
    }

    // Get All Employees
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Received request to fetch all employees.");
        return employeeService.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        logger.info("Received request to fetch employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public Optional<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        logger.info("Received request to update employee with ID: {}", id);
        return employeeService.updateEmployee(id, employeeDTO);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        logger.info("Received request to delete employee with ID: {}", id);
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? "Employee deleted successfully!" : "Employee not found!";
    }
}
