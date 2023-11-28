package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.ParameterSQLDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterSQLRecordsDto {
    private List<ParameterSQLDto> records;
    private int count;
}
