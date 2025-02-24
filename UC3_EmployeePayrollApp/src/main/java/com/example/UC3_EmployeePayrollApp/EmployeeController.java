package com.example.UC3_EmployeePayrollApp;

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

    @Autowired
    private EmployeeService service;

    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        logger.info("Received request to add employee: {}", employeeDTO.getEmail());
        return service.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Received request to fetch all employees.");
        return service.getAllEmployees();
    }
}
