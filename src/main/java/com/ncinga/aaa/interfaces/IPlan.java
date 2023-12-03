package com.ncinga.aaa.interfaces;


import com.ncinga.aaa.dtos.PlanDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanRecordsDto;

import java.util.List;

public interface IPlan {

    PlanDto addPlan(PlanDto record);

    PlanRecordsDto getAllPlans(PaginationRequestDto paginationRequestDto);

    List<PlanDto> editPlan(PlanDto record);

    List<PlanDto> getPlan(int id);

    void deletePlan(int id);
}
