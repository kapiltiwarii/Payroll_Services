package com.example.UC3_EmployeePayrollApp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private double salary;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    // Default Constructor
    public EmployeeDTO() {
    }

    // Parameterized Constructor
    public EmployeeDTO(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
