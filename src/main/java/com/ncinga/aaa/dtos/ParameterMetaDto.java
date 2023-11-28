package com.ncinga.aaa.dtos;

import com.ncinga.aaa.entity.ParameterMetaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterMetaDto extends BaseDto<ParameterMetaDto, ParameterMetaEntity> {
    private int parameter_id;
    private String parameter_name;
    private String parameter_lib_path;
    private String parameter_method_symbol;
    private String exec_phase;
    private String parameter_status;
}
