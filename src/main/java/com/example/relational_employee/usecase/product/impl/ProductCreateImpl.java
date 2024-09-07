package com.example.relational_employee.usecase.product.impl;

import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import com.example.relational_employee.exception.EmployeeNotFoundException;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.service.ProductService;
import com.example.relational_employee.usecase.product.ProductCreate;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("productCreateUseCase")
public class ProductCreateImpl implements ProductCreate {

    private final ProductService productService;

    private final EmployeeService employeeService;

    @Autowired
    public ProductCreateImpl(ProductService productService, EmployeeService employeeService) {
        this.productService = productService;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<SmallestProductDto> create(@NonNull final Long employeeId, @NonNull final ProductCreatePayload payload) {
        final EmployeeJpa employee = employeeService.getById(employeeId).orElseThrow(EmployeeNotFoundException::new);
        final ProductJpa createdProduct = productService.create(employee, payload);

        return ResponseEntity
                .created(null)
                .body(SmallestProductDto.toDto(createdProduct));
    }
}