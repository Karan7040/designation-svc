package com.colruytgroup.designation.controller;

import com.colruytgroup.designation.controller.api.EmployeeApiController;
import com.colruytgroup.designation.exception.EmployeeNotFoundException;
import com.colruytgroup.designation.mapper.EmployeeMapper;
import com.colruytgroup.designation.model.dto.EmployeeDto;
import com.colruytgroup.designation.model.dto.FutureDesignationDto;
import com.colruytgroup.designation.model.dto.UpdateEmployeeDto;
import com.colruytgroup.designation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ResponseEntity<Void> updateEmployee(UpdateEmployeeDto updateEmployeeDto) {
        employeeService.updateEmployee(updateEmployeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateEmployeeName(String id, String firstName, String lastName) {
        employeeService.updateEmployeeName(id, firstName, lastName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<FutureDesignationDto>> getFutureDesignations(String id) {
        return new ResponseEntity<>(employeeMapper.map(employeeService.getFutureDesignations(id)), HttpStatus.OK);
    }
}
