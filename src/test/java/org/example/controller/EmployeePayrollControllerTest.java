
/*
 * File: EmployeePayrollControllerTest.java
 * Description: JUnit 5 test class for verifying all Employee Payroll
 *              REST Controller endpoints using standalone MockMvc.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmployeePayrollControllerTest {

    private MockMvc mockMvc;

    // Initialize the controller before every test.
    @BeforeEach
    void setUp() {
        EmployeePayrollController controller = new EmployeePayrollController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Test GET request to check the service.
    @Test
    void testGetAllEmployees() throws Exception {

        mockMvc.perform(get("/employeepayrollservice/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Employee Payroll Service is running"));
    }

    // Test GET request using employee ID.
    @Test
    void testGetEmployeeById() throws Exception {

        mockMvc.perform(get("/employeepayrollservice/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.message")
                        .value("Employee ID received successfully"));
    }

    // Test POST request with employee JSON data.
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
                .andExpect(jsonPath("$.employee.name").value("Lisa"))
                .andExpect(jsonPath("$.employee.salary").value(2000));
    }

    // Test PUT request with updated employee JSON data.
    @Test
    void testUpdateEmployee() throws Exception {

        String employeeJson = """
                {
                    "name": "Lisa",
                    "salary": 2500
                }
                """;

        mockMvc.perform(put("/employeepayrollservice/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee.name").value("Lisa"))
                .andExpect(jsonPath("$.employee.salary").value(2500));
    }

    // Test DELETE request using employee ID.
    @Test
    void testDeleteEmployee() throws Exception {

        mockMvc.perform(delete("/employeepayrollservice/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.message")
                        .value("Employee delete request received successfully"));
    }
}