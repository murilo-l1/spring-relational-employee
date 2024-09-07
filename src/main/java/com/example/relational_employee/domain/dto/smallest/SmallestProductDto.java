package com.example.relational_employee.domain.dto.smallest;

import com.example.relational_employee.domain.entity.ProductJpa;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class SmallestProductDto {

    @NonNull
    private final Long id;

    @NonNull
    private final String name;

    @NonNull
    private final BigDecimal price;

    @Builder
    protected SmallestProductDto(@NonNull @NotNull final Long id,
                                 @NonNull @NotNull final String name,
                                 @NonNull @NotNull final BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public static SmallestProductDto toDto(@NonNull @NotNull final ProductJpa product){
        return SmallestProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static List<SmallestProductDto> toDto(@NonNull @NotNull final List<ProductJpa> products){
        return products.stream().map(SmallestProductDto::toDto).toList();
    }

}
