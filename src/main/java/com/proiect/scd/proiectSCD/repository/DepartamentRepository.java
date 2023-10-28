package com.proiect.scd.proiectSCD.repository;

import com.proiect.scd.proiectSCD.entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {

    Departament findByName(String name);
}

