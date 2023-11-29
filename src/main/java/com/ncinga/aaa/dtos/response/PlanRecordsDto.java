package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.PlanDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanRecordsDto {
    private List<PlanDto> records;
    private int count;
}
