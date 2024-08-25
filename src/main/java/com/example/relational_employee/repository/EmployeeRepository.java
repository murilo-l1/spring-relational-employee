package com.example.relational_employee.repository;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeJpa, Long>, JpaSpecificationExecutor<EmployeeJpa> {

    Optional<EmployeeJpa> getOneById(@NonNull @NotNull final Long id);

}