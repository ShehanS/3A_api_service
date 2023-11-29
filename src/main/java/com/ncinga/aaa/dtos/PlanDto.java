package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.PlanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto extends BaseDto<PlanDto, PlanEntity> {
    private int plan_id;
    private int type_id;
    private String plan_name;
    private String description;

}
