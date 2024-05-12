package com.colruytgroup.designation.mapper;

import com.colruytgroup.designation.model.dto.EmployeeDto;
import com.colruytgroup.designation.model.entity.DefaultOptionEntity;
import com.colruytgroup.designation.model.entity.EmployeeEntity;
import com.colruytgroup.designation.model.entity.FutureDesignationEntity;
import com.colruytgroup.designation.model.vo.DefaultDesignationVo;
import com.colruytgroup.designation.model.vo.EmployeeVo;
import com.colruytgroup.designation.model.vo.FutureDesignationVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto map(EmployeeVo employeeVo);

    FutureDesignationVo map(FutureDesignationEntity futureDesignationEntity);

    DefaultDesignationVo map(DefaultOptionEntity defaultOptionEntity);

    @Mapping(target = "currentDesignation.id",source = "employeeEntity.designationId")
    @Mapping(target = "currentDesignation.name",source = "employeeEntity.currentDesignationName")
    EmployeeVo map(EmployeeEntity employeeEntity, List<FutureDesignationVo> futureOptions, List<DefaultDesignationVo> defaultOptions);
}
