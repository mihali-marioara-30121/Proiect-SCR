package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.dtos.DepartamentDTO;
import com.proiect.scd.proiectSCD.entity.Departament;
import com.proiect.scd.proiectSCD.repository.DepartamentRepository;

import java.util.List;

public class DepartamentServiceImpl implements DepartamentService {

    //private final DepartamentRepository departamentRepository;
    @Override
    public Departament findDepartamentById(Long id) {
        return null;
    }

    @Override
    public Departament saveDepartament(Departament departament) {
        return null;
    }

    @Override
    public boolean deleteDepartamentById(Long id) {
        return false;
    }

    @Override
    public List<DepartamentDTO> getALlDepartaments() {
        return null;
    }
}
