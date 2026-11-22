
/*
 * File: EmployeePayrollControllerTest.java
 * Description: JUnit tests for Employee Payroll REST Controller
 *              integrated with the in-memory Service Layer.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.controller;

import org.example.service.EmployeePayrollService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmployeePayrollControllerTest {

    private MockMvc mockMvc;

    // Create Controller and Service before every test.
    @BeforeEach
    void setUp() {
        EmployeePayrollService service = new EmployeePayrollService();

        EmployeePayrollController controller =
                new EmployeePayrollController(service);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Test GET all employees when the List is empty.
    @Test
    void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employeepayrollservice/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    // Test GET employee by ID when the employee does not exist.
    @Test
    void testGetEmployeeByIdNotFound() throws Exception {
        mockMvc.perform(get("/employeepayrollservice/get/1"))
                .andExpect(status().isNotFound());
    }

    // Test POST request to create an employee.
    @Test
    void testCreateEmployee() throws Exception {
        String employeeJson = """
                {
                    "name": "Lisa",
                    "salary": 2000
                }
                """;

        mockMvc.perform(post("/employeepayrollservice/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Lisa"))
                .andExpect(jsonPath("$.salary").value(2000));
    }

    // Test PUT request when the List is empty.
    @Test
    void testUpdateEmployeeWhenListIsEmpty() throws Exception {
        String employeeJson = """
                {
                    "name": "Lisa",
                    "salary": 2500
                }
                """;

        mockMvc.perform(put("/employeepayrollservice/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isNotFound());
    }

    // Test DELETE request when the employee does not exist.
    @Test
    void testDeleteEmployeeNotFound() throws Exception {
        mockMvc.perform(delete("/employeepayrollservice/delete/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("Employee not found"));
    }

    // Test complete employee CRUD flow using the same in-memory List.
    @Test
    void testCompleteEmployeePayrollFlow() throws Exception {

        String createJson = """
                {
                    "name": "Lisa",
                    "salary": 2000
                }
                """;

        // Create employee.
        mockMvc.perform(post("/employeepayrollservice/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Lisa"))
                .andExpect(jsonPath("$.salary").value(2000));

        // Verify employee is present in the List.
        mockMvc.perform(get("/employeepayrollservice/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lisa"));

        // Retrieve employee by ID.
        mockMvc.perform(get("/employeepayrollservice/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lisa"));

        String updateJson = """
                {
                    "name": "Lisa",
                    "salary": 2500
                }
                """;

        // Update employee.
        mockMvc.perform(put("/employeepayrollservice/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").value(2500));

        // Verify updated salary.
        mockMvc.perform(get("/employeepayrollservice/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").value(2500));

        // Delete employee.
        mockMvc.perform(delete("/employeepayrollservice/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Employee deleted successfully"));

        // Verify employee has been removed.
        mockMvc.perform(get("/employeepayrollservice/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

}