package com.example.relational_employee.usecase.product;

import com.example.relational_employee.domain.entity.ProductJpa;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductFetch {

    ResponseEntity<List<ProductJpa>> findByEmployeeId(@NonNull @NotNull final Long employeeId);



}
