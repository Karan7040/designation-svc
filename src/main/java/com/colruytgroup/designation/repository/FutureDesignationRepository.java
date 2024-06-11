package com.colruytgroup.designation.repository;

import com.colruytgroup.designation.model.entity.FutureDesignationEntity;
import com.colruytgroup.designation.repository.rowmapper.FutureDesignationRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FutureDesignationRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<FutureDesignationEntity> getFutureDesignation(Integer futureOptionOne, Integer futureOptionTwo) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("optionOne", futureOptionOne)
                .addValue("optionTwo", futureOptionTwo);
        return namedParameterJdbcTemplate.query("""
                SELECT * FROM DSVC_FTR_DESIGNATIONS
                WHERE FTR_DESIGNATION_ID IN (:optionOne,:optionTwo)
                """, parameterSource, new FutureDesignationRowMapper());
    }
}
