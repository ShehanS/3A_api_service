package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.PlanAttributeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanAttributeRecordsDto {
    private List<PlanAttributeDto> results;
    private int count;
}
