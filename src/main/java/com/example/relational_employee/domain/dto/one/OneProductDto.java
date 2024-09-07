package com.example.relational_employee.domain.dto.one;

import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.ProductJpa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OneProductDto extends SmallestProductDto {

    @NonNull
    private final Integer quantity;

    @NonNull
    private final String employee_name;

    @Builder(builderMethodName = "oneBuilder")
    protected OneProductDto(@NonNull @NotNull final Long id,
                            @NonNull @NotBlank final String name,
                            @NonNull @NotNull final BigDecimal price,
                            @NonNull @NotNull final Integer quantity,
                            @NonNull @NotBlank final String employee_name) {
        super(id, name, price);
        this.quantity = quantity;
        this.employee_name = employee_name;
    }

    public static OneProductDto toDto(@NonNull final ProductJpa product){

        return OneProductDto.oneBuilder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .employee_name(product.getEmployee().getName())
                .build();
    }

}
