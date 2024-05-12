package com.colruytgroup.designation.repository.rowmapper;

import com.colruytgroup.designation.model.entity.EmployeeEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeEntity> {
    @Override
    public EmployeeEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return EmployeeEntity.builder()
                .id(resultSet.getString("ID"))
                .firstName(resultSet.getString("FIRST_NAME"))
                .lastName(resultSet.getString("LAST_NAME"))
                .surveyStatus("Y".equals(resultSet.getString("SURVEY_STATUS")))
                .designationId(resultSet.getInt("DESIGNATION_ID"))
                .currentDesignationName(resultSet.getString("DESIGNATION_NAME"))
                .selectedFutureDesignation(resultSet.getInt("FTR_DESIGNATION"))
                .selectedDefaultOption(resultSet.getInt("NONDSGN_OPTION"))
                .futureDesignationOpt1(resultSet.getInt("FTR_DES_OPT1"))
                .futureDesignationOpt2(resultSet.getInt("FTR_DES_OPT2"))
                .build();
    }
}
