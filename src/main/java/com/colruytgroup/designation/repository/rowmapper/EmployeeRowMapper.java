package com.colruytgroup.designation.repository.rowmapper;

import com.colruytgroup.designation.model.entity.EmployeeEntity;
import com.colruytgroup.designation.model.enums.Indicator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class EmployeeRowMapper implements RowMapper<EmployeeEntity> {
    @Override
    public EmployeeEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return EmployeeEntity.builder()
                .id(resultSet.getString("ID"))
                .firstName(resultSet.getString("FIRST_NAME"))
                .lastName(resultSet.getString("LAST_NAME"))
                .surveyStatus(Indicator.convertToBoolean(resultSet.getString("SURVEY_STATUS")))
                .designationId(resultSet.getInt("DESIGNATION_ID"))
                .currentDesignationName(resultSet.getString("DESIGNATION_NAME"))
                .selectedFutureDesignation(getInt(resultSet, "FTR_DESIGNATION"))
                .selectedDefaultOption(getInt(resultSet, "NONDSGN_OPTION"))
                .futureDesignationOpt1(getInt(resultSet, "FTR_DES_OPT1"))
                .futureDesignationOpt2(getInt(resultSet, "FTR_DES_OPT2"))
                .build();
    }

    private Integer getInt(ResultSet resultSet, String columnName) throws SQLException {
        return Objects.isNull(resultSet.getString(columnName)) ? null : resultSet.getInt(columnName);
    }
}
