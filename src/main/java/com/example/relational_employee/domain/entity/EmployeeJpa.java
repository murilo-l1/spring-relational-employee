package com.example.relational_employee.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = EmployeeJpa.TABLE_NAME)
public class EmployeeJpa {

    protected static final String TABLE_NAME = "employees";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    @Column(name="name", nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Min(value = 10)
    @Column(name = "address_number", nullable = false)
    private Integer addressNumber;

}