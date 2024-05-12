package com.colruytgroup.designation.controller.api;

import com.colruytgroup.designation.model.dto.EmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/designationsvc/employees")
public interface EmployeeApiController {

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> getEmployee(@PathVariable String employeeId);

}
