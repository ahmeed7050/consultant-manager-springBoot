package com.consultantmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultantmanager.model.Consultant;

import java.util.Optional;

public interface ConsultantRepo extends JpaRepository<Consultant, Long> {
    void deleteEmployeeById(Long id);

    Optional<Consultant> findEmployeeById(Long id);
}
