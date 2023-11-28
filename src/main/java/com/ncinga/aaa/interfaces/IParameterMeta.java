package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.ParameterMetaDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ParameterMetaRecordsDto;

import java.util.List;

public interface IParameterMeta {
    ParameterMetaDto addParameterMeta(ParameterMetaDto record);

    ParameterMetaRecordsDto getParametersMeta(PaginationRequestDto paginationRequestDto);

    List<ParameterMetaDto> editParameterMeta(ParameterMetaDto record);

    List<ParameterMetaDto> getParameterMeta(int id);

    void deleteParameterMeta(int id);
}
