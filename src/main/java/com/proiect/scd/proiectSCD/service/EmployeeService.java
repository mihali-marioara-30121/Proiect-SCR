package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    boolean deleteEmployeeById(Long id);

    List<Employee> getAllEmployeeByManager(String managerName);

    List<Employee> getAllEmployeesByDepartament(String departament);

}
