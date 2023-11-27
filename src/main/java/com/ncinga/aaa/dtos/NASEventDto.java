package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NASEventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASEventDto extends BaseDto<NASEventDto, NASEventEntity>{
    private int nas_id;
    private String nas_name;
    private String nas_type;
    private String nas_attrgroup;
    private String nas_secret;
    private Date created_date;
    private int group_id;
}
