package com.example.relational_employee.usecase.product.impl;

import com.example.relational_employee.domain.entity.ProductJpa;
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

    @Autowired
    public ProductFetchImpl(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public ResponseEntity<List<ProductJpa>> findByEmployeeId(@NonNull Long employeeId) {
        return ResponseEntity
                .ok()
                .body(productService.getByEmployeeId(employeeId));
    }
}