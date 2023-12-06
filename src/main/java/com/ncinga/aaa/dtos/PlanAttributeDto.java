package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.PlanAttributeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanAttributeDto extends BaseDto<PlanAttributeDto, PlanAttributeEntity> {
    private int attribute_id;
    private int plan_id;
    private String attribute_name;
    private String attribute_value;
    private int attribute_group;
    private String include_plan_state;
    private String status;
}
