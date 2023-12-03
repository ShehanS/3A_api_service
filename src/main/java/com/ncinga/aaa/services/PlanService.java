package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.PlanDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanRecordsDto;
import com.ncinga.aaa.entity.PlanEntity;
import com.ncinga.aaa.interfaces.IPlan;
import com.ncinga.aaa.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService implements IPlan {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public PlanDto addPlan(PlanDto record) {
        PlanEntity planEntity = record.toEntity(PlanEntity.class);
        try {
            PlanEntity result = planRepository.save(planEntity);
            return PlanDto.fromEntity(result, PlanDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Plan", e);
        }
    }

    @Override
    public PlanRecordsDto getAllPlans(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<PlanEntity> planEntities = planRepository.findAll(pageRequest);
            int count = planRepository.getRecordCount();
            if (planEntities.hasContent()) {
                List<PlanDto> result = planEntities.getContent().stream()
                        .map(record -> PlanDto.fromEntity(record, PlanDto.class))
                        .collect(Collectors.toList());
                return new PlanRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PlanDto> editPlan(PlanDto record) {
        try {
            List<PlanDto> result = new ArrayList<>();
            PlanEntity findRecord = planRepository.findById(record.getPlan_id()).orElseThrow();
            findRecord.setType_id(record.getType_id());
            findRecord.setPlan_name(record.getPlan_name());
            findRecord.setDescription(record.getDescription());
            PlanEntity update = planRepository.save(findRecord);
            PlanDto updateResult = PlanDto.fromEntity(update, PlanDto.class);
            result.add(updateResult);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PlanDto> getPlan(int id) {
        try {
            List<PlanEntity> records = planRepository.findByByPlanId(id);
            return records.stream().map(r -> PlanDto.fromEntity(r, PlanDto.class)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletePlan(int id) {
        try {
            planRepository.deleteByPlanId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
