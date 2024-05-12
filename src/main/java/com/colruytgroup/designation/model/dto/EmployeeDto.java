package com.colruytgroup.designation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private boolean surveyStatus;
    private CurrentDesignationDto currentDesignation;
    private List<FutureDesignationDto> futureOptions;
    private List<DefaultDesignationDto> defaultOptions;
    private FutureDesignationDto futureDesignation;
    private DefaultDesignationDto defaultDesignation;
}
