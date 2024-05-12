package com.colruytgroup.designation.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentDesignationDto {
    private Integer id;
    private String name;
}
