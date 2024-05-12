package com.colruytgroup.designation.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeEntity {
    private String id;
    private String firstName;
    private String lastName;
    private Integer designationId;
    private String currentDesignationName;
    private boolean surveyStatus;
    private Integer selectedFutureDesignation;
    private Integer selectedDefaultOption;
    private Integer futureDesignationOpt1;
    private Integer futureDesignationOpt2;

}
