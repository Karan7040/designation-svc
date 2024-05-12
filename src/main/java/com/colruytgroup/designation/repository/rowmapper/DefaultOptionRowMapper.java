package com.colruytgroup.designation.repository.rowmapper;

import com.colruytgroup.designation.model.entity.DefaultOptionEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultOptionRowMapper implements RowMapper<DefaultOptionEntity> {
    @Override
    public DefaultOptionEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return DefaultOptionEntity
                .builder()
                .id(resultSet.getInt("DSVC_NONDSGN_ID"))
                .name(resultSet.getString("DSVC_NONDSGN_NAME"))
                .build();
    }
}
