package com.example.relational_employee.usecase.product.impl;

import com.example.relational_employee.domain.dto.one.OneProductDto;
import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.exception.EmployeeNotFoundException;
import com.example.relational_employee.exception.ProductNotAvailableException;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.service.ProductService;
import com.example.relational_employee.usecase.product.ProductFetch;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productFetchUseCase")
public class ProductFetchImpl implements ProductFetch {

    private final ProductService productService;
    private final EmployeeService employeeService;

    @Autowired
    public ProductFetchImpl(ProductService productService, EmployeeService employeeService) {
        this.productService = productService;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<List<SmallestProductDto>> findByEmployeeId(@NonNull final Long employeeId) {
        List<ProductJpa> products = productService.findByEmployeeId(employeeId);
        return ResponseEntity
                .ok()
                .body(SmallestProductDto.toDto(products));
    }

    @Override
    public ResponseEntity<OneProductDto> getById(@NonNull final Long id, @NonNull final Long employeeId) {
        employeeService.getById(employeeId).orElseThrow(EmployeeNotFoundException::new);

        final ProductJpa product = productService.getById(id, employeeId).orElseThrow(ProductNotAvailableException::new);

        return ResponseEntity
                .ok()
                .body(OneProductDto.toDto(product));
    }
}