package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.COAEventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class COAEventRecordsDto {
    private List<COAEventDto> records;
    private int count;
}
