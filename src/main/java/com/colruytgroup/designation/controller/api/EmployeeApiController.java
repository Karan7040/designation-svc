package com.colruytgroup.designation.controller.api;

import com.colruytgroup.designation.model.dto.EmployeeDto;
import com.colruytgroup.designation.model.dto.UpdateEmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/designationsvc/employees")
public interface EmployeeApiController {

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> getEmployee(@PathVariable String employeeId);

    @PostMapping(value = "/update_employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateEmployee(@RequestBody UpdateEmployeeDto updateEmployeeDto);

    @PutMapping(value = "/update_employee_name/{id}")
    ResponseEntity<Void> updateEmployeeName(@PathVariable String id, @RequestParam String firstName, @RequestParam String lastName);
}
