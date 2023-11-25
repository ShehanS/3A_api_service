package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.GetRecordsDto;
import com.ncinga.aaa.dtos.response.AVERecordsDto;

import java.util.List;

public interface IAVPService {
    AVPRecordDto addRecord(AVPRecordDto record);

    AVERecordsDto getAvpRecords(GetRecordsDto getRecordsDto);

    List<AVPRecordDto> editRecord(AVPRecordDto record);

    List<AVPRecordDto> getRecord(int id);

    void deleteRecord(int id);


}
