package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.PlanTypeDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanTypeRecordsDto;

import java.util.List;

public interface IPlanType {
    PlanTypeDto addPlanType(PlanTypeDto record);

    PlanTypeRecordsDto getAllPlanType(PaginationRequestDto paginationRequestDto);

    List<PlanTypeDto> editPlanType(PlanTypeDto record);

    List<PlanTypeDto> getPlanType(int id);

    void deletePlanType(int id);
}
