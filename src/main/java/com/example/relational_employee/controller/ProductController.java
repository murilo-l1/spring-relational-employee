package com.example.relational_employee.controller;

import com.example.relational_employee.domain.dto.one.OneProductDto;
import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import com.example.relational_employee.usecase.product.ProductCreate;
import com.example.relational_employee.usecase.product.ProductFetch;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping(value = "api/employees/{employeeId}/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductFetch productFetch;
    private final ProductCreate productCreate;

    @Autowired
    public ProductController(ProductFetch productFetch, ProductCreate productCreate) {
        this.productFetch = productFetch;
        this.productCreate = productCreate;
    }

    @GetMapping
    public ResponseEntity<List<SmallestProductDto>> findByEmployeeId(@PathVariable("employeeId") @NonNull final Long employeeId){
        return productFetch.findByEmployeeId(employeeId);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<OneProductDto> getById(@PathVariable("employeeId") @NonNull final Long employeeId,
                                                 @PathVariable("productId")  @NonNull final Long productId){
        return productFetch.getById(productId, employeeId);
    }

    @PostMapping
    public ResponseEntity<SmallestProductDto> addProduct(@PathVariable("employeeId") @NonNull final Long employeeId,
                                                 @RequestBody @NonNull final ProductCreatePayload payload){
        return productCreate.create(employeeId, payload);
    }

}