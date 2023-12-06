package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.SubscriberEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDto extends BaseDto<SubscriberDto, SubscriberEntity> {
    private int subscriber_id;
    @NotBlank(message = "Missing username")
    private String username;
    @NotBlank(message = "Missing password")
    private String password;
    @NotBlank(message = "Missing Account Status")
    private String status;
    private String contact_no;
    @NotBlank(message = "Missing email")
    private String email;
    private Timestamp created_date;
    private Timestamp updated_time;
}
