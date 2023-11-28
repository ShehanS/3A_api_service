package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.ParameterSQLDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ParameterSQLRecordsDto;

import java.util.List;

public interface IParameterSQL {
    ParameterSQLDto addParameterSQL(ParameterSQLDto record);

    ParameterSQLRecordsDto getParametersSQL(PaginationRequestDto paginationRequestDto);

    List<ParameterSQLDto> editParameterSQL(ParameterSQLDto record);

    List<ParameterSQLDto> getParameterSQL(int id);

    void deleteParameterSQL(int id);
}
