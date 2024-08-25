package com.example.relational_employee.exception;

import com.example.relational_employee.domain.constant.ReasonConstants;

public class EmployeeNotFoundException extends NotFoundException{

    public EmployeeNotFoundException() {
        super(ReasonConstants.EMPLOYEE_NOT_FOUND);
    }
}