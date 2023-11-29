package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.PlanTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanTypeDto extends BaseDto<PlanTypeDto, PlanTypeEntity>{
    private int type_id;
    private String type_name;
    private String description;
}
