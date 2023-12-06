package com.ncinga.aaa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bb_attrgroup_accounting_avp_override")
public class AVPRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int override_id;
    private int attrgroup_id;
    private String vp_name;
    private String substitute_vp;
    private String extract_regexp;
    private String extract_sscanf;
}
