package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.ParameterSQLDto;
import com.ncinga.aaa.dtos.PlanParameterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanParameterRecordsDto;
import com.ncinga.aaa.entity.PlanParameterEntity;
import com.ncinga.aaa.interfaces.IPlanParameter;
import com.ncinga.aaa.repository.PlanParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanParameterService implements IPlanParameter {

    @Autowired
    private PlanParameterRepository planParameterRepository;

    @Override
    public PlanParameterDto addPlanParameter(PlanParameterDto record) {
        PlanParameterEntity planParameterEntity = record.toEntity(PlanParameterEntity.class);
        try {
            PlanParameterEntity result = planParameterRepository.save(planParameterEntity);
            if (result != null) {
                return PlanParameterDto.fromEntity(result, PlanParameterDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public PlanParameterRecordsDto getAllPlanParameters(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<PlanParameterEntity> planParameterEntities = planParameterRepository.findAll(pageRequest);
            int count = planParameterRepository.getRecordCount();
            if (planParameterEntities.hasContent()) {
                List<PlanParameterDto> result = planParameterEntities.getContent().stream()
                        .map(record -> ParameterSQLDto.fromEntity(record, PlanParameterDto.class))
                        .collect(Collectors.toList());
                return new PlanParameterRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PlanParameterDto> editPlanParameter(PlanParameterDto record) {
        try {
            List<PlanParameterDto> result = new ArrayList<>();
            PlanParameterEntity findRecord = planParameterRepository.findById(record.getPlan_id()).orElseThrow();
            findRecord.setParameter_value(record.getParameter_value());
            findRecord.setParameter_name(record.getParameter_name());
            findRecord.setReject_on_failure(record.getReject_on_failure());
            PlanParameterEntity update = planParameterRepository.save(findRecord);
            PlanParameterDto updateResult = ParameterSQLDto.fromEntity(update, PlanParameterDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PlanParameterDto> getPlanParameter(int id) {
        try {
            List<PlanParameterEntity> records = planParameterRepository.findByByPlanId(id);
            return records.stream().map(r -> PlanParameterDto.fromEntity(r, PlanParameterDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteParameter(int id) {
        try {
            planParameterRepository.deleteByPlanId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
