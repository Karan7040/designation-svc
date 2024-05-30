package com.colruytgroup.designation.controller.api;

import com.colruytgroup.designation.model.dto.EmployeeDto;
import com.colruytgroup.designation.model.dto.FutureDesignationDto;
import com.colruytgroup.designation.model.dto.UpdateEmployeeDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/designationsvc/employees")
@Validated
public interface EmployeeApiController {

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> getEmployee(@PathVariable String employeeId);

    @PostMapping(value = "/update_employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateEmployee(@RequestBody UpdateEmployeeDto updateEmployeeDto);

    @PutMapping(value = "/update_employee_name/{id}")
    ResponseEntity<Void> updateEmployeeName(@PathVariable String id, @NotBlank(message = "first name must not be blank") @RequestParam String firstName, @RequestParam String lastName);

    @DeleteMapping(value = "/delete_employee/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable String id);

    @GetMapping(value = "/future_designations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FutureDesignationDto>> getFutureDesignations(@PathVariable String id);
}
