package com.colruytgroup.designation.repository.rowmapper;

import com.colruytgroup.designation.model.entity.FutureDesignationEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FutureDesignationRowMapper implements RowMapper<FutureDesignationEntity> {
    @Override
    public FutureDesignationEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return FutureDesignationEntity
                .builder()
                .id(resultSet.getInt("FTR_DESIGNATION_ID"))
                .name(resultSet.getString("FTR_DESIGNATION_NAME"))
                .build();

    }
}
