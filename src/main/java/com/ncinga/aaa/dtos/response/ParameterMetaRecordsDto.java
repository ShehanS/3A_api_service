package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.ParameterMetaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterMetaRecordsDto {
    private List<ParameterMetaDto> records;
    private int count;
}
