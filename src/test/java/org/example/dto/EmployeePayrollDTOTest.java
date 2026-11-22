
/*
 * File: EmployeePayrollDTOTest.java
 * Description: JUnit tests for EmployeePayrollDTO constructors,
 *              getters and setters.
 *
 * Name: Manthan Hanchate
 * Date: 16/11/2026
 */

package org.example.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollDTOTest {

    // Test parameterized constructor and getters.
    @Test
    void testParameterizedConstructor() {
        EmployeePayrollDTO dto =
                new EmployeePayrollDTO("Lisa", 2000);

        assertEquals("Lisa", dto.getName());
        assertEquals(2000, dto.getSalary());
    }

    // Test default constructor and setters.
    @Test
    void testDefaultConstructorAndSetters() {
        EmployeePayrollDTO dto = new EmployeePayrollDTO();

        dto.setName("John");
        dto.setSalary(3000);

        assertEquals("John", dto.getName());
        assertEquals(3000, dto.getSalary());
    }
}