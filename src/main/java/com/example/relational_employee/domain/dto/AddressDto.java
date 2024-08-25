package com.example.relational_employee.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {

    @NonNull
    @NotNull
    private final String address;

    @NonNull
    @NotNull
    private final Integer addressNumber;

    @Builder
    protected AddressDto(@NonNull @NotNull @NotBlank String address,
                         @NonNull @NotNull Integer addressNumber){
        this.address = address;
        this.addressNumber = addressNumber;
    }

}