package com.example.relational_employee.usecase.product.impl;

import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import com.example.relational_employee.service.ProductService;
import com.example.relational_employee.usecase.product.ProductCreate;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("productCreateUseCase")
public class ProductCreateImpl implements ProductCreate {

    private final ProductService productService;

    @Autowired
    public ProductCreateImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductJpa> create(@NonNull final Long employeeId, @NonNull final ProductCreatePayload payload) {
        final ProductJpa createdProduct = productService.create(employeeId, payload);

        return ResponseEntity
                .created(null)
                .body(createdProduct);
    }
}