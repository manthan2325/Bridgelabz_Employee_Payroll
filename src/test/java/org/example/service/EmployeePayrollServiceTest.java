
/*
 * File: EmployeePayrollServiceTest.java
 * Description: JUnit tests for in-memory Employee Payroll List
 *              operations in the Service Layer.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.service;

import org.example.dto.EmployeePayrollDTO;
import org.example.model.EmployeePayrollModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    private EmployeePayrollService employeePayrollService;

    // Create a fresh Service object before every test.
    @BeforeEach
    void setUp() {
        employeePayrollService = new EmployeePayrollService();
    }

    // Test retrieving all employees from an empty List.
    @Test
    void testGetEmployeePayrollDataInitiallyEmpty() {
        List<EmployeePayrollModel> employees =
                employeePayrollService.getEmployeePayrollData();

        assertNotNull(employees);
        assertTrue(employees.isEmpty());
    }

    // Test adding an employee to the List.
    @Test
    void testAddEmployeePayrollData() {
        EmployeePayrollDTO dto =
                new EmployeePayrollDTO("Lisa", 2000);

        EmployeePayrollModel employee =
                employeePayrollService.addEmployeePayrollData(dto);

        assertNotNull(employee);
        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());

        assertEquals(
                1,
                employeePayrollService.getEmployeePayrollData().size()
        );
    }

    // Test retrieving an employee by its List position.
    @Test
    void testGetEmployeePayrollDataById() {
        EmployeePayrollDTO dto =
                new EmployeePayrollDTO("Lisa", 2000);

        employeePayrollService.addEmployeePayrollData(dto);

        EmployeePayrollModel employee =
                employeePayrollService.getEmployeePayrollDataById(1);

        assertNotNull(employee);
        assertEquals("Lisa", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    // Test returning null for an invalid employee ID.
    @Test
    void testGetEmployeePayrollDataByInvalidId() {
        EmployeePayrollModel employee =
                employeePayrollService.getEmployeePayrollDataById(1);

        assertNull(employee);
    }

    // Test updating the first employee in the List.
    @Test
    void testUpdateEmployeePayrollData() {
        employeePayrollService.addEmployeePayrollData(
                new EmployeePayrollDTO("Lisa", 2000)
        );

        EmployeePayrollModel updatedEmployee =
                employeePayrollService.updateEmployeePayrollData(
                        new EmployeePayrollDTO("Lisa", 2500)
                );

        assertNotNull(updatedEmployee);
        assertEquals("Lisa", updatedEmployee.getName());
        assertEquals(2500, updatedEmployee.getSalary());

        assertEquals(
                1,
                employeePayrollService.getEmployeePayrollData().size()
        );
    }

    // Test updating when the List is empty.
    @Test
    void testUpdateEmployeePayrollDataWhenListIsEmpty() {
        EmployeePayrollModel employee =
                employeePayrollService.updateEmployeePayrollData(
                        new EmployeePayrollDTO("Lisa", 2500)
                );

        assertNull(employee);
    }

    // Test deleting an employee from the List.
    @Test
    void testDeleteEmployeePayrollData() {
        employeePayrollService.addEmployeePayrollData(
                new EmployeePayrollDTO("Lisa", 2000)
        );

        Map<String, Object> response =
                employeePayrollService.deleteEmployeePayrollData(1);

        assertEquals("Employee deleted successfully",
                response.get("message"));

        assertEquals(1, response.get("id"));

        assertTrue(
                employeePayrollService.getEmployeePayrollData().isEmpty()
        );
    }

    // Test deleting an employee with an invalid ID.
    @Test
    void testDeleteEmployeePayrollDataWithInvalidId() {
        Map<String, Object> response =
                employeePayrollService.deleteEmployeePayrollData(1);

        assertEquals("Employee not found", response.get("message"));
        assertTrue(
                employeePayrollService.getEmployeePayrollData().isEmpty()
        );
    }
}