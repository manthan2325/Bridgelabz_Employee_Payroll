
/*
 * File: EmployeePayrollController.java
 * Description: REST Controller that handles Employee Payroll
 *              requests through the in-memory Service Layer.
 *
 * Name: Manthan Hanchate
 * Date: 19/11/2026
 */

package org.example.controller;

import org.example.dto.EmployeePayrollDTO;
import org.example.model.EmployeePayrollModel;
import org.example.service.EmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final EmployeePayrollService employeePayrollService;

    // Inject Service Layer dependency using constructor injection.
    @Autowired
    public EmployeePayrollController(
            EmployeePayrollService employeePayrollService) {

        this.employeePayrollService = employeePayrollService;
    }

    // GET: Return all employees stored in the in-memory List.
    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollModel>> getAllEmployees() {
        return ResponseEntity.ok(
                employeePayrollService.getEmployeePayrollData()
        );
    }

    // GET by ID: Return an employee using its List position.
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollModel> getEmployeeById(
            @PathVariable int id) {

        EmployeePayrollModel employee =
                employeePayrollService.getEmployeePayrollDataById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    // POST: Add a new employee to the in-memory List.
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollModel> createEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee =
                employeePayrollService.addEmployeePayrollData(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // PUT: Update the first employee in the in-memory List.
    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollModel> updateEmployee(
            @RequestBody EmployeePayrollDTO employeeDTO) {

        EmployeePayrollModel employee =
                employeePayrollService.updateEmployeePayrollData(employeeDTO);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    // DELETE: Remove an employee from the in-memory List.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(
            @PathVariable int id) {

        Map<String, Object> response =
                employeePayrollService.deleteEmployeePayrollData(id);

        if ("Employee not found".equals(response.get("message"))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(response);
    }
}