package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.NASEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.COAEventRecordsDto;
import com.ncinga.aaa.dtos.response.NASEventRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.NASEventService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/nas/record/")
public class NASEventController {

    @Autowired
    private NASEventService nasEventService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> addNASRAcord(@RequestBody NASEventDto payload) {
        ResponseMessageDto response = null;
        try {
            NASEventDto result = nasEventService.addNASEvent(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_NAS_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_NAS_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAllNASRecords(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            NASEventRecordsDto result = nasEventService.getAllNASEvents(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_EVENTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_EVENTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editCOARecord(@RequestBody NASEventDto nasEventDto) {
        ResponseMessageDto response = null;
        try {
            List<NASEventDto> result = nasEventService.editNASEvent(nasEventDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_NAS_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_NAS_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteCOARecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            nasEventService.deleteNASEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_NAS_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_NAS_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<NASEventDto> result = nasEventService.getNASEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
