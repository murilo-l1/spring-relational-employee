package com.example.relational_employee.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = AddressJpa.TABLE_NAME)
public class AddressJpa {

    protected static final String TABLE_NAME = "employee_address";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "employee_id", updatable = false, insertable = false)
    private Long employeeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", unique = true)
    private EmployeeJpa employeeJpa;

    @NotNull
    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Min(value = 10)
    @Column(name = "address_number", nullable = false)
    private Integer addressNumber;

}