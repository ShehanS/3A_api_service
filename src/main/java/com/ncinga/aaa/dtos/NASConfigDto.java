package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NASConfigEntity;
import com.ncinga.aaa.validator.NotBlankWithFieldName;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASConfigDto extends BaseDto<NASConfigDto, NASConfigEntity>{
    private int nas_id;
   // @NotBlank(message = "The field 'NAS Name' cannot be blank")
    private String nas_name;
   // @NotBlank(message = "The field 'NAS Type' cannot be blank")
    private String nas_type;
    private int nas_attrgroup;
    private String nas_secret;
    private Date created_date;
    private int group_id;
}
