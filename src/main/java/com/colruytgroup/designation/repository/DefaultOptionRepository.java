package com.colruytgroup.designation.repository;

import com.colruytgroup.designation.model.entity.DefaultOptionEntity;
import com.colruytgroup.designation.repository.rowmapper.DefaultOptionRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DefaultOptionRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<DefaultOptionEntity> getDefaultOptions() {
        return namedParameterJdbcTemplate.query("""
                SELECT * FROM DSVC_NONDSGN_OPTIONS
                """, new DefaultOptionRowMapper());
    }
}
