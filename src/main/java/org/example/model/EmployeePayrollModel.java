
/*
 * File: EmployeePayrollModel.java
 * Description: Model class representing employee payroll
 *              information with name and salary.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.model;

public class EmployeePayrollModel {

    // Employee payroll attributes.
    private String name;
    private double salary;

    // Default constructor.
    public EmployeePayrollModel() {
    }

    // Parameterized constructor.
    public EmployeePayrollModel(String name, double salary) {
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