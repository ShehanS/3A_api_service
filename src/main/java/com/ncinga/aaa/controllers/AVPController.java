package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AVERecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.AVPService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/avp/record")
public class AVPController {

    @Autowired
    private AVPService avpService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> addRecord(@RequestBody AVPRecordDto payload) {
        ResponseMessageDto response = null;
        try {
            AVPRecordDto result = avpService.addRecord(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_AVP_RECORD_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAllRecord(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            AVERecordsDto result = avpService.getAvpRecords(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_AVP_RECORD_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editRecord(@RequestBody AVPRecordDto avpRecordDto) {
        ResponseMessageDto response = null;
        try {
            List<AVPRecordDto> result = avpService.editRecord(avpRecordDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.UPDATE_AVP_RECORD_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.UPDATE_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            avpService.deleteRecord(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_AVP_RECORD_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<AVPRecordDto> result = avpService.getRecord(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_AVP_RECORD_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
