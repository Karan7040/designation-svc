package com.colruytgroup.designation.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeVo {
    private String id;
    private String firstName;
    private String lastName;
    private boolean surveyStatus;
    private CurrentDesignationVo currentDesignation;
    private List<FutureDesignationVo> futureOptions;
    private List<DefaultDesignationVo> defaultOptions;
    private FutureDesignationVo futureDesignation;
    private DefaultDesignationVo defaultDesignation;
}
