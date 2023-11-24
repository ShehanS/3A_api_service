package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bb_attrgroup_accounting_avp_override")
public class AVPRecordEntity {
    @Id
    private int attrgroup_id = 1;
    private String vp_name;
    private String substitute_vp;
    private String extract_regexp;
    private String extract_sscanf;
}
