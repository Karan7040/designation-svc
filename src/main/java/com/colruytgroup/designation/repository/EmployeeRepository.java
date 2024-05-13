package com.colruytgroup.designation.repository;

import com.colruytgroup.designation.model.entity.EmployeeEntity;
import com.colruytgroup.designation.model.enums.Indicator;
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

    public void update(EmployeeEntity employeeEntity) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("employeeId", employeeEntity.getId())
                .addValue("firstName", employeeEntity.getFirstName())
                .addValue("lastName", employeeEntity.getLastName())
                .addValue("currentDesignation", employeeEntity.getDesignationId())
                .addValue("surveyStatus", Indicator.convertToString(employeeEntity.isSurveyStatus()))
                .addValue("futureDesignationId", employeeEntity.getSelectedFutureDesignation())
                .addValue("defaultDesignationId", employeeEntity.getSelectedDefaultOption());
        namedParameterJdbcTemplate.update("""
                UPDATE DSVC_EMPLOYEE SET ID=:employeeId, FIRST_NAME=:firstName,
                LAST_NAME=:lastName, CUR_DESIGNATION=:currentDesignation, SURVEY_STATUS=:surveyStatus,
                FTR_DESIGNATION=:futureDesignationId, NONDSGN_OPTION=:defaultDesignationId WHERE
                ID=:employeeId;
                """, parameterSource);
    }
}
