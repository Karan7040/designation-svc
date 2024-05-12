package com.colruytgroup.designation.repository;

import com.colruytgroup.designation.model.entity.EmployeeEntity;
import com.colruytgroup.designation.repository.rowmapper.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Optional<EmployeeEntity> getEmployeeById(String employeeId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("employeeId", employeeId);
        return namedParameterJdbcTemplate.query(
                        """
                                SELECT *
                                FROM  DSVC_EMPLOYEE e
                                JOIN DSVC_DESIGNATIONS d ON e.CUR_DESIGNATION = d.DESIGNATION_ID
                                WHERE E.ID=:employeeId;
                                """, parameterSource, new EmployeeRowMapper())
                .stream().findFirst();
    }

}
