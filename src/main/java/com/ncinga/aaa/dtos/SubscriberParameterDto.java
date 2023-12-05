package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.SubscriberParameterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberParameterDto extends BaseDto<SubscriberParameterDto, SubscriberParameterEntity> {
    private int subscriber_id;
    private String parameter_name;
    private String parameter_value;
    private int reject_on_failure;

}
