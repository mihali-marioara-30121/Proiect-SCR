package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.dtos.DepartamentDTO;
import com.proiect.scd.proiectSCD.entity.Departament;

import java.util.List;

public interface DepartamentService {

    Departament findDepartamentById(Long id);
    Departament findDepartamentByName(String departamentName);

    Departament saveDepartament(Departament departament);

    boolean deleteDepartamentById (Long id);

    List<DepartamentDTO> getALlDepartaments();

}
