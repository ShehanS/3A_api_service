package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.NASEventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NASEventRecordsDto {
    private List<NASEventDto> records;
    private int count;
}
