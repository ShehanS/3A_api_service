package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NASWhitelistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASWhitelistDto extends BaseDto<NASWhitelistDto, NASWhitelistEntity> {
    private int subscriber_id;
    private String nas_id_pattern;
}
