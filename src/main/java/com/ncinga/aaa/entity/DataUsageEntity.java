package com.ncinga.aaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bb_subscriber_data_usage")
public class DataUsageEntity {
    @Id
    private int usage_id;
    private int subscriber_id;
    private String username;
    private long total_download;
    private long total_upload;
    private long total_usage;
    private Date report_date;
    private Date last_reset;
}
