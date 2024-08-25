package com.example.relational_employee.usecase.employee;

import com.example.relational_employee.domain.dto.one.OneEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeFetch {

    ResponseEntity<List<OneEmployee>> findAll();

    ResponseEntity<List<SmallestEmployee>> findAllSmall();

    ResponseEntity<OneEmployee> findById(@NonNull @NotNull final Long id);

    ResponseEntity<?> deleteById(@NonNull @NotNull final Long id);

}