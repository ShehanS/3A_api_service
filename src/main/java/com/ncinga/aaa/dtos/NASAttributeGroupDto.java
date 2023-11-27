package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASAttributeGroupDto extends BaseDto<NASAttributeGroupDto, NASAttributeGroupEntity>{
    private int group_id;
    private String group_name;
    private String group_description;
}
