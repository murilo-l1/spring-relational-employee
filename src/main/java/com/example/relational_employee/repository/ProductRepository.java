package com.example.relational_employee.repository;

import com.example.relational_employee.domain.entity.ProductJpa;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductJpa, Long>, JpaSpecificationExecutor<ProductJpa>{

    List<ProductJpa> findByEmployeeIdOrderByQuantityAsc(@NonNull @NotNull final Long employeeId);

    @Query("SELECT p FROM ProductJpa p WHERE p.employeeId = :employeeId " +
            "AND p.id = :id " +
            "AND p.quantity > 0")
    Optional<ProductJpa> getByIdAndEmployeeId(@NonNull @Param("id") final Long id, @NonNull @Param("employeeId") final Long employeeId);

}