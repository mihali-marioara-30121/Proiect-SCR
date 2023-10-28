package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.Manager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService{
    @Override
    public Manager findManagerById(Long id) {
        return null;
    }

    @Override
    public Manager saveManager(Manager manager) {
        return null;
    }

    @Override
    public boolean deleteManagerById(Long id) {
        return false;
    }

    @Override
    public Manager findManagerByDepartament(String departamentName) {
        return null;
    }

    @Override
    public List<Manager> getAllManagersByDepartament(String departament) {
        return null;
    }
}
