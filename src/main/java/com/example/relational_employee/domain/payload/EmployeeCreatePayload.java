package com.example.relational_employee.domain.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeCreatePayload {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    private final String name;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private final String address;

    @NotNull
    private final Integer addressNumber;

}