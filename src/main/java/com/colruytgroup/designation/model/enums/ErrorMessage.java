package com.colruytgroup.designation.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {
    EMPLOYEE_NOT_FOUND("Employee does not exist");
    private final String message;
}
