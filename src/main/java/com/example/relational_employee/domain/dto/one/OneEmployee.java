package com.example.relational_employee.domain.dto.one;

import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestProductDto;
import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OneEmployee extends SmallestEmployee {

    private final String address;
    private final Integer addressNumber;
    private final List<SmallestProductDto> products;

    @Builder(builderMethodName = "oneBuilder")
    protected OneEmployee(@NonNull @NotNull final Long id,
                          @NonNull @NotBlank final String name,
                          @NonNull @NotBlank final String address,
                          @NonNull @NotNull final Integer addressNumber,
                          @NonNull @NotNull final List<SmallestProductDto> products){
        super(name, id);
        this.address = address;
        this.addressNumber = addressNumber;
        this.products = products;
    }

    public static OneEmployee toOneDto(@NonNull final EmployeeJpa employeeJpa,
                                       @NonNull final List<SmallestProductDto> products){

        return OneEmployee.oneBuilder()
                .id(employeeJpa.getId())
                .name(employeeJpa.getName())
                .address(employeeJpa.getAddress())
                .addressNumber(employeeJpa.getAddressNumber())
                .products(products)
                .build();
    }

}