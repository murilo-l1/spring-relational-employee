package com.example.relational_employee.controller;

import com.example.relational_employee.domain.dto.one.OneEmployee;
import com.example.relational_employee.domain.dto.smallest.SmallestEmployee;
import com.example.relational_employee.domain.payload.EmployeeCreatePayload;
import com.example.relational_employee.usecase.employee.EmployeeCreate;
import com.example.relational_employee.usecase.employee.EmployeeFetch;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "employeeController")
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeFetch fetch;

    private final EmployeeCreate create;

    public EmployeeController(EmployeeFetch fetch, EmployeeCreate create) {
        this.fetch = fetch;
        this.create = create;
    }

    @GetMapping
    public ResponseEntity<List<SmallestEmployee>> findAll(){
        return fetch.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OneEmployee> findById(@PathVariable("id") final Long id){
        return fetch.getById(id);
    }

    @PostMapping
    public ResponseEntity<SmallestEmployee> create(@RequestBody @NonNull final EmployeeCreatePayload payload){
        return create.createEmployee(payload);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") @NonNull final Long id){
        return fetch.deleteById(id);
    }


}