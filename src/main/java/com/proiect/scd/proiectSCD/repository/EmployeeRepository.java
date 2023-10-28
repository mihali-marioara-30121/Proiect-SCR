package com.proiect.scd.proiectSCD.repository;

import com.proiect.scd.proiectSCD.entity.Departament;
import com.proiect.scd.proiectSCD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartamentName( String departamentName);
}
