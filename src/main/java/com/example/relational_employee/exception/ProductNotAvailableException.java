package com.example.relational_employee.exception;

import com.example.relational_employee.domain.constant.ReasonConstants;

public class ProductNotAvailableException extends NotFoundException{

    public ProductNotAvailableException() {
        super(ReasonConstants.PRODUCT_NOT_AVAILABLE);
    }
}
