
/*
 * File: EmployeePayrollController.java
 * Description: REST Controller for handling Employee Payroll API requests.
 *              Demonstrates GET, GET by ID, POST, PUT and DELETE methods.
 *              This UC focuses on REST connectivity and data transmission.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // GET: Check whether the Employee Payroll REST service is running.
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> getAllEmployees() {

        return ResponseEntity.ok(
                Map.of("message", "Employee Payroll Service is running")
        );
    }

    // GET by ID: Receive an employee ID and return a sample response.
    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                Map.of(
                        "message", "Employee ID received successfully",
                        "id", id
                )
        );
    }

    // POST: Receive employee data in JSON format.
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEmployee(
            @RequestBody Map<String, Object> employeeData) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        Map.of(
                                "message", "Employee data received successfully",
                                "employee", employeeData
                        )
                );
    }

    // PUT: Receive updated employee data in JSON format.
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateEmployee(
            @RequestBody Map<String, Object> employeeData) {

        return ResponseEntity.ok(
                Map.of(
                        "message", "Employee update data received successfully",
                        "employee", employeeData
                )
        );
    }

    // DELETE: Receive an employee ID for the delete request.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(
            @PathVariable int id) {

        return ResponseEntity.ok(
                Map.of(
                        "message", "Employee delete request received successfully",
                        "id", id
                )
        );
    }
}