package com.example.relational_employee.usecase.product;

import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface ProductCreate {

    ResponseEntity<ProductJpa> create(@NonNull @NotNull final Long employeeId, @NonNull @NotNull final ProductCreatePayload payload);


}
