package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.PlanAttributeDto;
import com.ncinga.aaa.dtos.PlanParameterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanAttributeRecordsDto;
import com.ncinga.aaa.dtos.response.PlanParameterRecordsDto;

import java.util.List;

public interface IPlanAttribute {
    PlanAttributeDto addPlanAttribute(PlanAttributeDto record);

    PlanAttributeRecordsDto getAllPlanAttributes(PaginationRequestDto paginationRequestDto);

    List<PlanAttributeDto> editPlanAttribute(PlanAttributeDto record);

    List<PlanAttributeDto> getPlanAttribute(int id);

    void deletePlanAttribute(int id);
}
