package com.colruytgroup.designation.exception;

import com.colruytgroup.designation.model.enums.ErrorMessage;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super(ErrorMessage.EMPLOYEE_NOT_FOUND.getMessage());
    }
}
