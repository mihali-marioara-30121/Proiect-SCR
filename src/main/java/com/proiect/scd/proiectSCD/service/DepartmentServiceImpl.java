package com.proiect.scd.proiectSCD.service;

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
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        if (findDepartmentById(id) != null){
            // stergerea subdepartamentelor
            deleteSubdepartmentsIfTheyExist(id);
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void deleteSubdepartmentsIfTheyExist(Long parentId) {
        List<Department> subdepartmentsList = departmentRepository.findByParentDepartmentId(parentId);
        for (Department subdepartement: subdepartmentsList) {
            departmentRepository.deleteById(subdepartement.getId());
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
