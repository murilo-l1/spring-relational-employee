package com.example.relational_employee.repository;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductJpa, Long>, JpaSpecificationExecutor<ProductJpa>{

    List<ProductJpa> getByEmployeeId(@NonNull @NotNull final Long employeeId);


}