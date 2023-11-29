package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.PlanParameterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanParameterDto extends BaseDto<PlanParameterDto, PlanParameterEntity> {
    private int plan_id;
    private String parameter_name;
    private String parameter_value;
    private int reject_on_failure;
}
