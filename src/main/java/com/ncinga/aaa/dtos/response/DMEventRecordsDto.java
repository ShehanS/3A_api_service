package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.DMEventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DMEventRecordsDto {
    private List<DMEventDto> records;
    private int count;
}
