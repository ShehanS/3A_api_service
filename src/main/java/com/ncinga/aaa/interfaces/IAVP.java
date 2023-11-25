package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AVERecordsDto;

import java.util.List;

public interface IAVP {
    AVPRecordDto addRecord(AVPRecordDto record);

    AVERecordsDto getAvpRecords(PaginationRequestDto paginationRequestDto);

    List<AVPRecordDto> editRecord(AVPRecordDto record);

    List<AVPRecordDto> getRecord(int id);

    void deleteRecord(int id);


}
