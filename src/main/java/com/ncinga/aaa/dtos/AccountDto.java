package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto extends BaseDto<AccountDto, AccountEntity> {
    private int subscriber_id;
    private String username;
    private String acct_session_id;
    private String nas_ip_address;
    private String framed_ip_address;
    private int acct_status_type;
    private int acct_input_octets;
    private String acct_output_octets;
    private String framed_protocol;
    private int acct_input_gigawords;
    private int acct_output_gigawords;
    private String nas_port_id;
    private Date accunting_datetime;
}
