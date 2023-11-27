package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.NASEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASEventRecordsDto;

import java.util.List;

public interface INASEvent {
    NASEventDto addNASEvent(NASEventDto record);

    NASEventRecordsDto getAllNASEvents(PaginationRequestDto paginationRequestDto);

    List<NASEventDto> editNASEvent(NASEventDto record);

    List<NASEventDto> getNASEvent(int id);

    void deleteNASEvent (int id);
}
