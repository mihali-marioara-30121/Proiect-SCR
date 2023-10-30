package com.proiect.scd.proiectSCD.service;

import com.proiect.scd.proiectSCD.dtos.DepartmentDTO;
import com.proiect.scd.proiectSCD.entity.Department;
import com.proiect.scd.proiectSCD.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@SuppressWarnings("unused")
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department findDepartmentByName(String departamentName) {
        return departmentRepository.findByName(departamentName);
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        if (findDepartmentById(id)!=null){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(department -> new DepartmentDTO(department.getId(), department.getName(), department.getDescription()))
                .collect(Collectors.toList());
    }
}
