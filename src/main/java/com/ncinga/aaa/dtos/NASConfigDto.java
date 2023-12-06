package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import com.ncinga.aaa.entity.NASConfigEntity;
import com.ncinga.aaa.validator.NotBlankWithFieldName;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASConfigDto extends BaseDto<NASConfigDto, NASConfigEntity>{
    private int nas_id;
    private String nas_name;
    private String nas_type;
   // private int nas_attrgroup;
    private NASAttributeGroupEntity nas_attrgroup;
    private String nas_secret;

    private Timestamp created_date;
    private int group_id;
}
