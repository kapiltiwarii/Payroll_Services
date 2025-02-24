package com.example.UC4_EmployeePayrollApp;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Service Layer Dependency Injected using @Autowired
    @Autowired
    private EmployeeService employeeService;

    // Add Employee - Delegates to Service Layer
    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        logger.info("Received request to add employee: {}", employeeDTO.getEmail());
        return employeeService.addEmployee(employeeDTO);
    }

    // Get All Employees - Delegates to Service Layer
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Received request to fetch all employees.");
        return employeeService.getAllEmployees();
    }
}
