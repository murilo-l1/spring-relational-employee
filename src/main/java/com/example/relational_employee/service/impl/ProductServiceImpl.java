package com.example.relational_employee.service.impl;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.entity.ProductJpa;
import com.example.relational_employee.domain.payload.ProductCreatePayload;
import com.example.relational_employee.repository.ProductRepository;
import com.example.relational_employee.service.EmployeeService;
import com.example.relational_employee.service.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final EmployeeService employeeService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, EmployeeService employeeService) {
        this.productRepository = productRepository;
        this.employeeService = employeeService;
    }

    @Override
    public List<ProductJpa> getByEmployeeId(@NonNull @NotNull final Long employeeId) {
        return productRepository.getByEmployeeId(employeeId);
    }

    @Override
    public ProductJpa save(@NonNull @NotNull final ProductJpa product) {
        return productRepository.save(product);
    }

    @Override
    public ProductJpa create(@NonNull @NotNull final Long employeeId,
                             @NonNull @NotNull final ProductCreatePayload payload) {

        EmployeeJpa employee = employeeService.findById(employeeId);

        final ProductJpa product = new ProductJpa();
        product.setId(null);
        product.setEmployee(employee);
        product.setName(payload.getName());
        product.setQuantity(payload.getQuantity());
        product.setPrice(payload.getPrice());

        return productRepository.save(product);
    }


}