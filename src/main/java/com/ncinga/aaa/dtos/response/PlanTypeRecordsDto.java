package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.PlanTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanTypeRecordsDto {
    private List<PlanTypeDto> records;
    private int count;
}
