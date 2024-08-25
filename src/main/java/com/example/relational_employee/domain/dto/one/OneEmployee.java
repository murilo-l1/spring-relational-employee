package com.example.relational_employee.domain.dto.one;

import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
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




    @Builder(builderMethodName = "oneBuilder")
    protected OneEmployee(@NonNull @NotNull final Long id,
                          @NonNull @NotNull @NotBlank final String name){
        super(name, id);

    }

    public static OneEmployee toOneDto(@NonNull final EmployeeJpa employeeJpa){


        return OneEmployee.oneBuilder()
                .id(employeeJpa.getId())
                .name(employeeJpa.getName())
                .build();
    }

    public static List<OneEmployee> toOneDto(@NonNull final List<EmployeeJpa> employeeJpaList){
        return employeeJpaList.stream().map(OneEmployee::toOneDto).toList();
    }

}