package com.ncinga.aaa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsightRequestDto {
    private int subscriber_id;
    private String start_date;
    private String end_date;
    private String type;
}
