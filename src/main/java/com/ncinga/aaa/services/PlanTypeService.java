package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.ParameterSQLDto;
import com.ncinga.aaa.dtos.PlanTypeDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanTypeRecordsDto;
import com.ncinga.aaa.entity.PlanTypeEntity;
import com.ncinga.aaa.interfaces.IPlanType;
import com.ncinga.aaa.repository.PlanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanTypeService implements IPlanType {
    @Autowired
    private PlanTypeRepository planTypeRepository;

    @Override
    public PlanTypeDto addPlanType(PlanTypeDto record) {
        PlanTypeEntity parameterSQLEntity = record.toEntity(PlanTypeEntity.class);
        try {
            PlanTypeEntity result = planTypeRepository.save(parameterSQLEntity);
            if (result != null) {
                return PlanTypeDto.fromEntity(result, PlanTypeDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public PlanTypeRecordsDto getAllPlanType(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<PlanTypeEntity> parameterSQLEntities = planTypeRepository.findAll(pageRequest);
            int count = planTypeRepository.getRecordCount();
            if (parameterSQLEntities.hasContent()) {
                List<PlanTypeDto> result = parameterSQLEntities.getContent().stream()
                        .map(record -> ParameterSQLDto.fromEntity(record, PlanTypeDto.class))
                        .collect(Collectors.toList());
                return new PlanTypeRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PlanTypeDto> editPlanType(PlanTypeDto record) {
        try {
            List<PlanTypeDto> result = new ArrayList<>();
            PlanTypeEntity findRecord = planTypeRepository.findById(record.getType_id()).orElseThrow();
            findRecord.setType_name(record.getType_name());
            findRecord.setDescription(record.getDescription());
            PlanTypeEntity update = planTypeRepository.save(findRecord);
            PlanTypeDto updateResult = ParameterSQLDto.fromEntity(update, PlanTypeDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PlanTypeDto> getPlanType(int id) {
        try {
            List<PlanTypeEntity> records = planTypeRepository.findByByTypeId(id);
            return records.stream().map(r -> PlanTypeDto.fromEntity(r, PlanTypeDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletePlanType(int id) {
        try {
            planTypeRepository.deleteByTypeId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
