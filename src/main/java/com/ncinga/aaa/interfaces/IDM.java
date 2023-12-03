package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.DMEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.DMEventRecordsDto;

import java.util.List;

public interface IDM {
    DMEventDto addDMEvent(DMEventDto record);

    DMEventRecordsDto getAllDMEvents(PaginationRequestDto paginationRequestDto);

    List<DMEventDto> editDMEvent(DMEventDto record);

    List<DMEventDto> getDMEvent(int id);

    void deleteDMEvent(int id);
}
