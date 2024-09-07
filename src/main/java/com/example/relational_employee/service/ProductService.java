package com.example.relational_employee.service;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductJpa> findByEmployeeId(@NonNull @NotNull final Long employeeId);

    Optional<ProductJpa> getById(@NonNull @NotNull final Long id, @NonNull @NotNull final Long employeeId);

    ProductJpa save(@NonNull @NotNull final ProductJpa product);

    ProductJpa create(@NonNull @NotNull final EmployeeJpa employee, @NonNull @NotNull final ProductCreatePayload payload);

}