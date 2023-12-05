package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.SubscriberPlanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberPlanDto extends BaseDto<SubscriberPlanDto, SubscriberPlanEntity> {
    private int instance_id;
    private int subscriber_id;
    private int plan_id;
    private String plan_state;
    private Date status_date;
    private Date created_date;
}
