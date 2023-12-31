package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.AVPRecordDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AVERRecordsDto {
    private List<AVPRecordDto> records;
    private int count;

}
