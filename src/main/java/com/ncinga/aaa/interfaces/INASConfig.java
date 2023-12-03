package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.NASConfigDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;

import java.util.List;

public interface INASConfig {
    NASConfigDto addNAS(NASConfigDto record);

    com.ncinga.aaa.dtos.response.NASConfigDto getAllNAS(PaginationRequestDto paginationRequestDto);

    List<NASConfigDto> editNAS(NASConfigDto record);

    List<NASConfigDto> getNAS(int id);

    void deleteNAS (int id);
}
