package com.ncinga.aaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bb_accounting_record_filter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFilterEntity {
    @Id
    private int attrgroup_id;
    private String filter_avp;
    private String filter_regexp;
    private String filter_for;
}
