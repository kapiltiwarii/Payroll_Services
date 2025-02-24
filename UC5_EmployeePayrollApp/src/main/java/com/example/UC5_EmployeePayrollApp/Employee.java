package com.example.UC5_EmployeePayrollApp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Employee {

    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private double salary;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    // Default Constructor
    public Employee() {}

    // Parameterized Constructor
    public Employee(Long id, String name, double salary, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
