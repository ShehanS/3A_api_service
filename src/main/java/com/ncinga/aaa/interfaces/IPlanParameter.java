package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.PlanParameterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanParameterRecordsDto;

import java.util.List;

public interface IPlanParameter {
    PlanParameterDto addPlanParameter(PlanParameterDto record);

    PlanParameterRecordsDto getAllPlanParameters(PaginationRequestDto paginationRequestDto);

    List<PlanParameterDto> editPlanParameter(PlanParameterDto record);

    List<PlanParameterDto> getPlanParameter(int id);

    void deleteParameter(int id);
}
