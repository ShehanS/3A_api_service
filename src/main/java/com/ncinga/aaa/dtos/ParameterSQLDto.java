package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.ParameterSQLEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterSQLDto extends BaseDto<ParameterSQLDto, ParameterSQLEntity> {
    private int action_id;
    private String action_name;
    private String parameter_name;
    private String action_sql;
    private int action_seq;
    private int match_return;
    private String entity;
}
