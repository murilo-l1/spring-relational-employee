package com.example.relational_employee.usecase.employee.impl;

import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.payload.EmployeeCreatePayload;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.usecase.employee.EmployeeCreate;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("employeeCreateUseCase")
public class EmployeeCreateImpl implements EmployeeCreate {

    private final EmployeeService employeeService;

    public EmployeeCreateImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<SmallestEmployee> createEmployee(@NonNull @NotNull final EmployeeCreatePayload payload) {
        final EmployeeJpa employeeJpa = employeeService.create(payload);

        return ResponseEntity
                .ok()
                .body(SmallestEmployee.toDto(employeeJpa));

    }

}