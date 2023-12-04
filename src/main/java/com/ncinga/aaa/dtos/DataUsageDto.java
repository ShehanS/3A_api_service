package com.ncinga.aaa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataUsageDto {
    private int usage_id;
    private int subscriber_id;
    private String username;
    private long total_download;
    private long total_upload;
    private long total_usage;
    private Date report_date;
    private Date last_reset;
}
