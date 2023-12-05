package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.NASWhitelistDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASWhitelistRecordsDto {
    private List<NASWhitelistDto> records;
    private int count;
}
