package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.SubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;
import com.ncinga.aaa.services.SubscriberService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/subscribers/system")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody SubscriberDto payload) {
        ResponseMessageDto response = null;
        try {
            SubscriberDto result = subscriberService.addSubscriber(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            SubscriberRecordsDto result = subscriberService.getAllSubscribers(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody SubscriberDto record) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberDto> result = subscriberService.editSubscriber(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            subscriberService.deleteSubscriber(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberDto> result = subscriberService.getSubscriber(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
