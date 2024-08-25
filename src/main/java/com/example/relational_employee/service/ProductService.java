package com.example.relational_employee.service;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;

public interface ProductService {

    List<ProductJpa> getByEmployeeId(@NonNull @NotNull final Long employeeId);

    ProductJpa save(@NonNull @NotNull final ProductJpa product);

    ProductJpa create(@NonNull @NotNull final Long employeeId, @NonNull @NotNull final ProductCreatePayload payload);

}