package com.example.relational_employee.service.impl;

import com.example.relational_employee.domain.entity.EmployeeJpa;
import com.example.relational_employee.domain.payload.EmployeeCreatePayload;
import com.example.relational_employee.exception.EmployeeNotFoundException;
import com.example.relational_employee.repository.EmployeeRepository;
import com.example.relational_employee.service.EmployeeService;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeJpa findById(@NonNull final Long id) {
        return repository.getOneById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }


    @Override
    public EmployeeJpa create(@NonNull @NotNull final EmployeeCreatePayload payload) {
        EmployeeJpa employeeJpa = new EmployeeJpa();
        employeeJpa.setId(null);
        employeeJpa.setName(payload.getName());
        return repository.save(employeeJpa);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        boolean exists = repository.existsById(id);

        if(exists)
            repository.deleteById(id);
        else
            throw new EmployeeNotFoundException();
    }
}
