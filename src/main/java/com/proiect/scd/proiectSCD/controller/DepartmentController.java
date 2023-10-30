package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.dtos.DepartmentDTO;
import com.proiect.scd.proiectSCD.entity.Department;
import com.proiect.scd.proiectSCD.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/!#")
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getALlDepartments(){
        return ResponseEntity.ofNullable(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return ResponseEntity.ofNullable(departmentService.findDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        return ResponseEntity.ofNullable(departmentService.saveDepartment(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        department.setId(id);
        return ResponseEntity.ofNullable(departmentService.saveDepartment(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        boolean deletedSuccessfully = departmentService.deleteDepartmentById(id);
        if (deletedSuccessfully) {
            return new ResponseEntity<>("Successfully deleted department and related managers and employees!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Departament id not found!", HttpStatus.BAD_REQUEST);
    }

}
