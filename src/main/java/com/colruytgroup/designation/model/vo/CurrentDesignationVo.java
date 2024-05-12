package com.colruytgroup.designation.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentDesignationVo {
    private Integer id;
    private String name;
}
