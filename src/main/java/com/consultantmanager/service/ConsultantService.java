package com.consultantmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultantmanager.exception.UserNotFoundException;
import com.consultantmanager.model.Consultant;
import com.consultantmanager.repo.ConsultantRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ConsultantService {
    private final ConsultantRepo employeeRepo;

    @Autowired
    public ConsultantService(ConsultantRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Consultant addEmployee(Consultant employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Consultant> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Consultant updateEmployee(Consultant employee) {
        return employeeRepo.save(employee);
    }

    public Consultant findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
