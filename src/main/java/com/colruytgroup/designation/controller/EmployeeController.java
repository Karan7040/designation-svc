package com.colruytgroup.designation.controller;

import com.colruytgroup.designation.controller.api.EmployeeApiController;
import com.colruytgroup.designation.exception.EmployeeNotFoundException;
import com.colruytgroup.designation.mapper.EmployeeMapper;
import com.colruytgroup.designation.model.dto.EmployeeDto;
import com.colruytgroup.designation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController implements EmployeeApiController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Override
    public ResponseEntity<EmployeeDto> getEmployee(String employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId)
                .map(employeeMapper::map)
                .orElseThrow(EmployeeNotFoundException::new), HttpStatus.OK);
    }
}
