package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.SearchRequestDto;
import com.ncinga.aaa.dtos.response.AVERRecordsDto;

import java.util.List;

public interface IAVPService {
    AVPRecordDto addRecord(AVPRecordDto record);

    AVERRecordsDto getAvpRecords(SearchRequestDto searchRequestDto);
    AVPRecordDto editRecord(AVPRecordDto record);
    void deleteRecord(int id);

}
