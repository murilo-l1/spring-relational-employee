package com.example.relational_employee.usecase.employee.impl;

import com.example.relational_employee.domain.dto.one.OneEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.usecase.employee.EmployeeFetch;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "employeeFetch")
public class EmployeeFetchImpl implements EmployeeFetch {

    private final EmployeeService service;

    @Autowired
    public EmployeeFetchImpl(EmployeeService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<List<OneEmployee>> findAll() {
        List<EmployeeJpa> retrievedEmployeeJpas = service.findAll();

        List<OneEmployee> parsedEmployees = OneEmployee.toOneDto(retrievedEmployeeJpas);

        return ResponseEntity
                .ok()
                .body(parsedEmployees);
    }

    @Override
    public ResponseEntity<List<SmallestEmployee>> findAllSmall() {
        List<EmployeeJpa> retrievedEmployeeJpas = service.findAll();
        List<SmallestEmployee> parsedEmployees = SmallestEmployee.toDto(retrievedEmployeeJpas);

        return ResponseEntity
                .ok()
                .body(parsedEmployees);
    }

    @Override
    public ResponseEntity<OneEmployee> findById(@NonNull @NotNull final Long id) {
        EmployeeJpa retrievedEmployeeJpa = service.findById(id);

        return ResponseEntity
                .ok()
                .body(OneEmployee.toOneDto(retrievedEmployeeJpa));
    }


    @Override
    public ResponseEntity<?> deleteById(@NonNull @NotNull final Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}