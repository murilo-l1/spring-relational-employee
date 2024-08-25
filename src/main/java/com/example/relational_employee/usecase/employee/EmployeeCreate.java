package com.example.relational_employee.usecase.employee;

import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.payload.EmployeeCreatePayload;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface EmployeeCreate {

    ResponseEntity<SmallestEmployee> createEmployee(@NonNull @NotNull final EmployeeCreatePayload payload);

}