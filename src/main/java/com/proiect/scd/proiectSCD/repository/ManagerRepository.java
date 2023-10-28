package com.proiect.scd.proiectSCD.repository;

import com.proiect.scd.proiectSCD.entity.Departament;
import com.proiect.scd.proiectSCD.entity.Employee;
import com.proiect.scd.proiectSCD.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByDepartamentName(String departamentName);
}
