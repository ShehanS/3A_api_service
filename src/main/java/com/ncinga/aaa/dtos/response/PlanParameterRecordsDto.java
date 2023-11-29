package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.PlanParameterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanParameterRecordsDto {
    private List<PlanParameterDto> records;
    private int count;
}
