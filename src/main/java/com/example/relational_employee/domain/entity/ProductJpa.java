package com.example.relational_employee.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = ProductJpa.TABLE_NAME)
public class ProductJpa {

    protected static final String TABLE_NAME = "employee_products";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeJpa employee;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Min(0)
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @DecimalMax("9999999999.99")
    @DecimalMin("0.00")
    @Digits(integer = 10, fraction = 2)
    @Column(name = "price", nullable = false)
    private BigDecimal price;

}