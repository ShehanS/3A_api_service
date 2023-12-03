package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.SubscriberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDto extends BaseDto<SubscriberDto, SubscriberEntity> {
    private int subscriber_id;
    private String username;
    private String password;
    private String status;
    private String contact_no;
    private String email;
}
