package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.request.InsightRequestDto;
import com.ncinga.aaa.dtos.response.InsightResponseDto;
import com.ncinga.aaa.entity.DataUsageEntity;
import com.ncinga.aaa.repository.InsightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InsightService {
    @Autowired
    private InsightRepository insightRepository;

    public InsightResponseDto getTotalDownloads(InsightRequestDto insightRequestDto) {
        List<Map<String, Long>> downloadRecords = null;
        List<Map<String, Long>> uploadRecords = null;
        List<Map<String, Long>> totalUsageRecords = null;

        InsightResponseDto insightResponseDto = new InsightResponseDto();
        List<DataUsageEntity> usage = insightRepository.getUsageByDateRange(insightRequestDto.getStart_date(), insightRequestDto.getEnd_date(), insightRequestDto.getSubscriber_id()).orElseThrow();
        downloadRecords = usage.stream().map(r -> {
            Map<String, Long> record = new HashMap<>();
            record.put(dateToString(r.getReport_date()), r.getTotal_download());
            return record;
        }).collect(Collectors.toList());
        uploadRecords = usage.stream().map(r -> {
            Map<String, Long> record = new HashMap<>();
            record.put(dateToString(r.getReport_date()), r.getTotal_upload());
            return record;
        }).collect(Collectors.toList());
        totalUsageRecords = usage.stream().map(r -> {
            Map<String, Long> record = new HashMap<>();
            record.put(dateToString(r.getReport_date()), r.getTotal_usage());
            return record;
        }).collect(Collectors.toList());
        insightResponseDto.setDownloadGraphData(downloadRecords);
        insightResponseDto.setUploadGraphData(uploadRecords);
        insightResponseDto.setTotalGraphData(totalUsageRecords);
        insightResponseDto.setReportData(usage);
        return insightResponseDto;
    }

    private String dateToString(Date date) {
        Instant instant = date.toInstant();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }

}
