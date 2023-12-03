package com.ncinga.aaa.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NASConfigDto {
    private List<com.ncinga.aaa.dtos.NASConfigDto> records;
    private int count;
}
