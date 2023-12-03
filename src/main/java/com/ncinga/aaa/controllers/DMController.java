package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.DMEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.DMEventRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.DMService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dm/record")
public class DMController {

    @Autowired
    private DMService dmService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> addRDMcord(@RequestBody DMEventDto payload) {
        ResponseMessageDto response = null;
        try {
            DMEventDto result = dmService.addDMEvent(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_DM_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_DM_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAllDMRecords(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            DMEventRecordsDto result = dmService.getAllDMEvents(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_DM_EVENTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_DM_EVENTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editDMRecord(@RequestBody DMEventDto DMEventDto) {
        ResponseMessageDto response = null;
        try {
            List<DMEventDto> result = dmService.editDMEvent(DMEventDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_DM_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_DM_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteDMRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            dmService.deleteDMEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_DM_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_DM_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<DMEventDto> result = dmService.getDMEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_DM_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_DM_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
