package com.ncinga.aaa.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsightResponseDto {
    private Object downloadGraphData;
    private Object uploadGraphData;
    private Object totalGraphData;
    private Object reportData;
}
