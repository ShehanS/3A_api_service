package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.AVPRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AVPRecordDto extends BaseDto<AVPRecordDto, AVPRecordEntity> {
    private int attrgroup_id;
    private String vp_name;
    private String substitute_vp;
    private String extract_regexp;
    private String extract_sscanf;

}
