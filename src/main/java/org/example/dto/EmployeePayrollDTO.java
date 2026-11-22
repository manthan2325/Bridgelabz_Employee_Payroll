
/*
 * File: EmployeePayrollDTO.java
 * Description: Data Transfer Object used to receive employee
 *              name and salary from REST API requests.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.dto;

public class EmployeePayrollDTO {

    // Employee details received from the client.
    private String name;
    private double salary;

    // Default constructor required for JSON deserialization.
    public EmployeePayrollDTO() {
    }

    // Parameterized constructor.
    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter and setter for employee name.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for employee salary.
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}