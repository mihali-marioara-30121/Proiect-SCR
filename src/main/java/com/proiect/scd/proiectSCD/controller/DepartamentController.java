package com.proiect.scd.proiectSCD.controller;

import com.proiect.scd.proiectSCD.dtos.DepartamentDTO;
import com.proiect.scd.proiectSCD.entity.Departament;
import com.proiect.scd.proiectSCD.service.DepartamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/!#")
@RequestMapping("/api/departament")
@RequiredArgsConstructor
public class DepartamentController {
    private final DepartamentService departamentService;

    @GetMapping
    public ResponseEntity<List<DepartamentDTO>> getALlDepartaments(){
        return ResponseEntity.ofNullable(departamentService.getALlDepartaments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departament> getDepartament(@PathVariable Long id){
        return ResponseEntity.ofNullable(departamentService.findDepartamentById(id));
    }

    @PostMapping
    public ResponseEntity<Departament> createDepartament(@RequestBody Departament departament){
        return ResponseEntity.ofNullable(departamentService.saveDepartament(departament));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departament> updateDepartament(@PathVariable Long id, @RequestBody Departament departament){
        departament.setId(id);
        return ResponseEntity.ofNullable(departamentService.saveDepartament(departament));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartament(@PathVariable Long id){
        boolean deletedSuccessfully = departamentService.deleteDepartamentById(id);
        if (deletedSuccessfully) {
            return new ResponseEntity<>("Successfully deleted departament and related managers and employees!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Departament id not found!", HttpStatus.BAD_REQUEST);
    }

}
