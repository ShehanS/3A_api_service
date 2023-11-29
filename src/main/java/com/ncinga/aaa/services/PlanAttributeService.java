package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.PlanAttributeDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanAttributeRecordsDto;
import com.ncinga.aaa.entity.PlanAttributeEntity;
import com.ncinga.aaa.interfaces.IPlanAttribute;
import com.ncinga.aaa.repository.PlanAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanAttributeService implements IPlanAttribute {

    @Autowired
    private PlanAttributeRepository planAttributeRepository;

    @Override
    public PlanAttributeDto addPlanAttribute(PlanAttributeDto record) {
        PlanAttributeEntity attributeEntity = record.toEntity(PlanAttributeEntity.class);
        try {
            PlanAttributeEntity result = planAttributeRepository.save(attributeEntity);
            if (result != null) {
                return PlanAttributeDto.fromEntity(result, PlanAttributeDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public PlanAttributeRecordsDto getAllPlanAttributes(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<PlanAttributeEntity> attributeEntities = planAttributeRepository.findAll(pageRequest);
            int count = planAttributeRepository.getRecordCount();
            if (attributeEntities.hasContent()) {
                List<PlanAttributeDto> result = attributeEntities.getContent().stream()
                        .map(record -> PlanAttributeDto.fromEntity(record, PlanAttributeDto.class))
                        .collect(Collectors.toList());
                return new PlanAttributeRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PlanAttributeDto> editPlanAttribute(PlanAttributeDto record) {
        try {
            List<PlanAttributeDto> result = new ArrayList<>();
            PlanAttributeEntity findRecord = planAttributeRepository.findById(record.getPlan_id()).orElseThrow();
            findRecord.setAttribute_name(record.getAttribute_name());
            findRecord.setAttribute_value(record.getAttribute_value());
            findRecord.setAttribute_group(record.getAttribute_group());
            findRecord.setInclude_plan_state(record.getInclude_plan_state());
            findRecord.setStatus(record.getStatus());
            PlanAttributeEntity update = planAttributeRepository.save(findRecord);
            PlanAttributeDto updateResult = PlanAttributeDto.fromEntity(update, PlanAttributeDto.class);
            result.add(updateResult);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PlanAttributeDto> getPlanAttribute(int planId) {
        try {
            List<PlanAttributeEntity> records = planAttributeRepository.findByPlanId(planId);
            return records.stream().map(r -> PlanAttributeDto.fromEntity(r, PlanAttributeDto.class)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletePlanAttribute(int planId) {
        try {
            planAttributeRepository.deleteByPlanId(planId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
