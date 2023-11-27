package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.NASSubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASSubscribersRecordDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.NASSubscriberService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/subscriber/")
public class NASSubscriberController {

    @Autowired
    private NASSubscriberService nasSubscriberService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody NASSubscriberDto payload) {
        ResponseMessageDto response = null;
        try {
            NASSubscriberDto result = nasSubscriberService.addNASSubscriber(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_NAS_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_NAS_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            NASSubscribersRecordDto result = nasSubscriberService.getNASSubscribers(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_SUBSCRIBERS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_SUBSCRIBERS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody NASSubscriberDto avpRecordDto) {
        ResponseMessageDto response = null;
        try {
            List<NASSubscriberDto> result = nasSubscriberService.editNASSubscriber(avpRecordDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_NAS_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_NAS_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            nasSubscriberService.deleteRNASSubscriber(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_NAS_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_NAS_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
//        ResponseMessageDto response = null;
//        try {
//            List<AVPRecordDto> result = avpService.getRecord(Integer.parseInt(id));
//            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_AVP_RECORD_SUCCESS);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_AVP_RECORD_FAILED);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
