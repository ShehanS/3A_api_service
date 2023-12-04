package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.request.InsightRequestDto;
import com.ncinga.aaa.dtos.response.InsightResponseDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.InsightService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/insight")
public class InsightController {

    @Autowired
    private InsightService insightService;

    @PostMapping(value = "/get")
    public ResponseEntity<ResponseMessageDto> getTotalDownloadInsight(@RequestBody InsightRequestDto insightRequestDto) {
        ResponseMessageDto response = null;
        try {
            InsightResponseDto result = insightService.getTotalDownloads(insightRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_INSIGHT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_INSIGHT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
