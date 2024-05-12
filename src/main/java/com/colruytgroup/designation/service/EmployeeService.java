package com.colruytgroup.designation.service;

import com.colruytgroup.designation.model.vo.EmployeeVo;

import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeVo> getEmployeeById(String employeeId);
}
