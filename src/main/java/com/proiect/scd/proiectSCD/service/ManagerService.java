package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.Manager;
import java.util.List;
public interface ManagerService {
    Manager findManagerById(Long id);

    Manager saveManagere(Manager manager);

    boolean deleteManagerById(Long id);

    Manager findManagerByDepartament(String departamentName);

    List<Manager> getAllManagersByDepartament(String departament);
}
