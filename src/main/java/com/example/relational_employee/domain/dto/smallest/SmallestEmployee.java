package com.example.relational_employee.domain.dto.smallest;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmallestEmployee {

    private final Long id;

    @NonNull
    @NotNull
    private final String name;

    @Builder()
    protected SmallestEmployee(@NonNull final String name,
                               @NonNull final Long id){
        this.name = name;
        this.id = id;
    }

    public static SmallestEmployee toDto(final EmployeeJpa entity){
        return SmallestEmployee
                        .builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .build();
    }

    public static List<SmallestEmployee> toDto(final List<EmployeeJpa> entityList){
        return entityList.stream().map(SmallestEmployee::toDto).toList();
    }


}
