package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.entity.Employee;
import com.proiect.scd.proiectSCD.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeEontroller {
    private final EmployeeService employeeService;

    @GetMapping("/byDepartament/{departamentName}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartament(@PathVariable String departamentName) {
        return ResponseEntity.ofNullable(employeeService.getAllEmployeesByDepartament(departamentName));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ofNullable(employeeService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ofNullable(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ofNullable(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deletedSuccessfully = employeeService.deleteEmployeeById(id);
        if (deletedSuccessfully) {
            return new ResponseEntity<>("Successfully deleted employee!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee id not found!", HttpStatus.BAD_REQUEST);
    }
}
