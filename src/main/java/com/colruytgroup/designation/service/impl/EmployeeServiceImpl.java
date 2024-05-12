package com.colruytgroup.designation.service.impl;

import com.colruytgroup.designation.mapper.EmployeeMapper;
import com.colruytgroup.designation.model.entity.EmployeeEntity;
import com.colruytgroup.designation.model.vo.DefaultDesignationVo;
import com.colruytgroup.designation.model.vo.EmployeeVo;
import com.colruytgroup.designation.model.vo.FutureDesignationVo;
import com.colruytgroup.designation.repository.DefaultOptionRepository;
import com.colruytgroup.designation.repository.EmployeeRepository;
import com.colruytgroup.designation.repository.FutureDesignationRepository;
import com.colruytgroup.designation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final FutureDesignationRepository futureDesignationRepository;
    private final DefaultOptionRepository defaultOptionRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Optional<EmployeeVo> getEmployeeById(String employeeId) {
        return employeeRepository.getEmployeeById(employeeId)
                .map(this::fetchEmployeeDetails);
    }

    private EmployeeVo fetchEmployeeDetails(EmployeeEntity employeeEntity) {
        List<FutureDesignationVo> futureDesignationOptions = futureDesignationRepository.getFutureDesignation(employeeEntity.getFutureDesignationOpt1(), employeeEntity.getFutureDesignationOpt2())
                .stream().map(employeeMapper::map).toList();
        List<DefaultDesignationVo> defaultDesignations = defaultOptionRepository.getDefaultOptions()
                .stream().map(employeeMapper::map).toList();
        EmployeeVo employeeVo = employeeMapper.map(employeeEntity, futureDesignationOptions, defaultDesignations);
        if (employeeEntity.isSurveyStatus()) {
            FutureDesignationVo futureDesignation = futureDesignationOptions.stream()
                    .filter(futureDesignationVo -> futureDesignationVo.getId().equals(employeeEntity.getSelectedFutureDesignation()))
                    .findFirst().orElse(null);
            DefaultDesignationVo defaultDesignation = defaultDesignations.stream()
                    .filter(defaultOption -> defaultOption.getId().equals(employeeEntity.getSelectedDefaultOption()))
                    .findFirst().orElse(null);
            employeeVo.setFutureDesignation(futureDesignation);
            employeeVo.setDefaultDesignation(defaultDesignation);
        }
        return employeeVo;
    }
}
