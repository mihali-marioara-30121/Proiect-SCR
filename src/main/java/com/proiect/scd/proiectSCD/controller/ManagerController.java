package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.entity.Manager;
import com.proiect.scd.proiectSCD.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/byDepartament/{departamentName}")
    public ResponseEntity<List<Manager>> getManagerByDepartament(@PathVariable String departamentName) {
        return ResponseEntity.ofNullable(managerService.getAllManagersByDepartament(departamentName));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable Long id) {
        return ResponseEntity.ofNullable(managerService.findManagerById(id));
    }

    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        return ResponseEntity.ofNullable(managerService.saveManager(manager));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
        manager.setId(id);
        return ResponseEntity.ofNullable(managerService.saveManager(manager));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable Long id) {
        boolean deletedSuccessfully = managerService.deleteManagerById(id);
        if (deletedSuccessfully) {
            return new ResponseEntity<>("Successfully deleted manager!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Manager id not found!", HttpStatus.BAD_REQUEST);
    }
}
