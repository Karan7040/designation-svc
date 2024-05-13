package com.colruytgroup.designation.service;

import com.colruytgroup.designation.model.dto.UpdateEmployeeDto;
import com.colruytgroup.designation.model.vo.EmployeeVo;

import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeVo> getEmployeeById(String employeeId);

    void updateEmployee(UpdateEmployeeDto updateEmployee);

    void updateEmployeeName(String id, String firstName, String lastName);

    void deleteEmployee(String id);
}
