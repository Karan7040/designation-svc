package com.colruytgroup.designation.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefaultDesignationDto {
    private Integer id;
    private String name;
}
