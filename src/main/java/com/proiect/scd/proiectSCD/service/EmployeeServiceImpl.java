package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        return false;
    }

    @Override
    public Employee findEmployeeByDepartament(String departamentName) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployeesByDepartament(String departament) {
        return null;
    }
}
