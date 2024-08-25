package com.example.relational_employee.domain.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCreatePayload{

    @NotBlank
    private String name;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;
}