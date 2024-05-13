package com.colruytgroup.designation.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmployeeDto {
    private String id;
    private Integer futureDesignationId;
    private Integer defaultOptionId;
}
