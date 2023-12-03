package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.DMEventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DMEventDto extends BaseDto<DMEventDto, DMEventEntity> {
    private int event_id;
    private String username;
    private String status;
    private String event_response;
    private Date request_datetime;
}
