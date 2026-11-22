
/*
 * File: EmployeePayrollService.java
 * Description: Service layer that stores, retrieves, updates and
 *              deletes Employee Payroll data using an in-memory List.
 *
 * Name: Manthan Hanchate
 * Date: 16/11/2026
 */

package org.example.service;

import org.example.dto.EmployeePayrollDTO;
import org.example.model.EmployeePayrollModel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeePayrollService {

    // In-memory collection for storing employee payroll records.
    private final List<EmployeePayrollModel> employeePayrollList =
            new ArrayList<>();

    // Return all employee payroll records.
    public List<EmployeePayrollModel> getEmployeePayrollData() {
        return employeePayrollList;
    }

    // Return an employee using a 1-based position as the requested ID.
    public EmployeePayrollModel getEmployeePayrollDataById(int id) {
        int index = id - 1;

        if (index < 0 || index >= employeePayrollList.size()) {
            return null;
        }

        return employeePayrollList.get(index);
    }

    // Convert DTO into Model and add it to the in-memory List.
    public EmployeePayrollModel addEmployeePayrollData(
            EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee = new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        employeePayrollList.add(employee);

        return employee;
    }

    // Update the first employee because the specified PUT endpoint
    // does not provide an employee ID.
    public EmployeePayrollModel updateEmployeePayrollData(
            EmployeePayrollDTO employeeDTO) {

        if (employeePayrollList.isEmpty()) {
            return null;
        }

        EmployeePayrollModel employee = new EmployeePayrollModel(
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );

        employeePayrollList.set(0, employee);

        return employee;
    }

    // Delete an employee using a 1-based position as the requested ID.
    public Map<String, Object> deleteEmployeePayrollData(int id) {
        int index = id - 1;

        if (index < 0 || index >= employeePayrollList.size()) {
            return Map.of(
                    "message", "Employee not found",
                    "id", id
            );
        }

        employeePayrollList.remove(index);

        return Map.of(
                "message", "Employee deleted successfully",
                "id", id
        );
    }
}