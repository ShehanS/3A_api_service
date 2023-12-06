package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.AccountFilterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFilterDto extends BaseDto<AccountFilterDto, AccountFilterEntity> {
    private int id;
    private int attrgroup_id;
    private String filter_avp;
    private String filter_regexp;
    private String filter_for;
}
