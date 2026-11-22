
/*
 * File: EmployeePayrollServiceTest.java
 * Description: JUnit tests for EmployeePayrollService methods.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.service;

import org.example.dto.EmployeePayrollDTO;
import org.example.model.EmployeePayrollModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    private EmployeePayrollService employeePayrollService;

    // Create the Service object before each test.
    @BeforeEach
    void setUp() {
        employeePayrollService = new EmployeePayrollService();
    }

    // Test retrieving an employee model by ID.
    @Test
    void testGetEmployeePayrollDataById() {
        EmployeePayrollModel employee =
                employeePayrollService.getEmployeePayrollDataById(1);

        assertNotNull(employee);
        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    // Test creating an employee model from DTO.
    @Test
    void testAddEmployeePayrollData() {
        EmployeePayrollDTO dto =
                new EmployeePayrollDTO("John", 3000);

        EmployeePayrollModel employee =
                employeePayrollService.addEmployeePayrollData(dto);

        assertNotNull(employee);
        assertEquals("John", employee.getName());
        assertEquals(3000, employee.getSalary());
    }

    // Test updating an employee model from DTO.
    @Test
    void testUpdateEmployeePayrollData() {
        EmployeePayrollDTO dto =
                new EmployeePayrollDTO("Lisa", 2500);

        EmployeePayrollModel employee =
                employeePayrollService.updateEmployeePayrollData(dto);

        assertNotNull(employee);
        assertEquals("Lisa", employee.getName());
        assertEquals(2500, employee.getSalary());
    }

    // Test delete request response.
    @Test
    void testDeleteEmployeePayrollData() {
        Map<String, Object> response =
                employeePayrollService.deleteEmployeePayrollData(1);

        assertEquals(1, response.get("id"));
        assertEquals(
                "Employee delete request received successfully",
                response.get("message")
        );
    }
}