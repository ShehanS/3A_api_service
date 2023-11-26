package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.COAEventRecordsDto;

import java.util.List;

public interface ICOA {
    COAEventDto addCOAEvent(COAEventDto record);

    COAEventRecordsDto getAllCOAEvents(PaginationRequestDto paginationRequestDto);

    List<COAEventDto> editCOAEvent(COAEventDto record);

    List<COAEventDto> getCOAEvent(int id);

    void deleteCOAEvent(int id);
}
