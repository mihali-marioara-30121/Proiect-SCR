package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.Employee;
import com.proiect.scd.proiectSCD.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (findEmployeeById(id) != null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployeeByDepartament(String departamentName) {
        return employeeRepository.findByDepartamentName(departamentName);
    }

    @Override
    public List<Employee>getAllEmployeeByManager(String managerName) {
        return null;
    }


    @Override
    public List<Employee> getAllEmployeesByDepartament(String departament) {
        return null;
    }
}
