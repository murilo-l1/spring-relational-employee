package com.example.relational_employee.usecase.employee.impl;

import com.example.relational_employee.domain.dto.one.OneEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.exception.EmployeeNotFoundException;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.service.ProductService;
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

    private final EmployeeService employeeService;
    private final ProductService productService;

    @Autowired
    public EmployeeFetchImpl( EmployeeService employeeService, ProductService productService) {
        this.employeeService = employeeService;
        this.productService = productService;
    }


    @Override
    public ResponseEntity<List<SmallestEmployee>> findAll() {
        final List<EmployeeJpa> retrievedEmployees = employeeService.findAll();

        final List<SmallestEmployee> parsedEmployees = SmallestEmployee.toDto(retrievedEmployees);

        return ResponseEntity
                .ok()
                .body(parsedEmployees);
    }

    @Override
    public ResponseEntity<OneEmployee> getById(@NonNull @NotNull final Long id) {
        final EmployeeJpa retrievedEmployee = employeeService.getById(id).orElseThrow(EmployeeNotFoundException::new);
        final List<ProductJpa> employeeProducts = productService.findByEmployeeId(id);

        final List<SmallestProductDto> parsedProducts = SmallestProductDto.toDto(employeeProducts);

        return ResponseEntity
                .ok()
                .body(OneEmployee.toOneDto(retrievedEmployee, parsedProducts));
    }


    @Override
    public ResponseEntity<String> deleteById(@NonNull @NotNull final Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}