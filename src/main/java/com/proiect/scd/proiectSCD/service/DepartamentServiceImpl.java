package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.dtos.DepartamentDTO;
import com.proiect.scd.proiectSCD.entity.Departament;
import com.proiect.scd.proiectSCD.repository.DepartamentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@SuppressWarnings("unused")
public class DepartamentServiceImpl implements DepartamentService {

    private final DepartamentRepository departamentRepository;

    public DepartamentServiceImpl(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }

    @Override
    public Departament findDepartamentById(Long id) {
        return departamentRepository.findById(id).orElse(null);
    }

    @Override
    public Departament findDepartamentByName(String departamentName) {
        return departamentRepository.findByName(departamentName);
    }

    @Override
    public Departament saveDepartament(Departament departament) {
        return departamentRepository.save(departament);
    }

    @Override
    public boolean deleteDepartamentById(Long id) {
        if (findDepartamentById(id)!=null){
            departamentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DepartamentDTO> getALlDepartaments() {
        List<Departament> departaments = departamentRepository.findAll();

        return departaments.stream()
                .map(departament -> new DepartamentDTO(departament.getId(), departament.getName(), departament.getDescription()))
                .collect(Collectors.toList());
    }
}
