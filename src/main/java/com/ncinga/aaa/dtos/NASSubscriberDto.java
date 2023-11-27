package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.NasSubscriberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASSubscriberDto extends BaseDto<NASSubscriberDto, NasSubscriberEntity> {
    private int subscriber_id;
    private int attribute_group;
    private String attribute;
    private String operation;
    private String value;
}
