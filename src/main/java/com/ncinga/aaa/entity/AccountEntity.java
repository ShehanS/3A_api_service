package com.ncinga.aaa.entity;

import com.ncinga.aaa.validator.NotBlankWithFieldName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "bb_accounting_data")
public class AccountEntity {
    @Id
    private int subscriber_id;
    @NotBlankWithFieldName(fieldName = "username")
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


//<th style={{width: 120}}>Subscriber ID</th>
//<th style={{width: 150}}>username</th>
//<th style={{width: 150}}>Session ID</th>
//<th style={{width: 150}}>ACC.State Type</th>
//<th style={{width: 150}}>ACC Input Octets</th>
//<th style={{width: 150}}>ACC Output Octets</th>
//<th style={{width: 150}}>ACC Input Gigwords</th>
//<th style={{width: 150}}>ACC Output Gigwords</th>
//<th style={{width: 150}}>NAS IP</th>
//<th style={{width: 150}}>NAS Port</th>
//<th style={{width: 150}}>Frame IP</th>
//<th style={{width: 150}}>Frame Protocol</th>
//<th style={{width: 150}}>Date</th>
