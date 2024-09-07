package com.example.relational_employee.service;


import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.payload.EmployeeCreatePayload;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeJpa> findAll();
    Optional<EmployeeJpa> getById(@NonNull @NotNull final Long id);
    EmployeeJpa create(@NonNull @NotNull final EmployeeCreatePayload payload);
    void deleteById(@NonNull @NotNull final Long id);

}