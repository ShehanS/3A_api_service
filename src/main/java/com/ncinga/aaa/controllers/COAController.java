package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.COAEventRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.COAService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/coa/record")
public class COAController {

    @Autowired
    private COAService coaService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> addRCOAcord(@RequestBody COAEventDto payload) {
        ResponseMessageDto response = null;
        try {
            COAEventDto result = coaService.addCOAEvent(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_COA_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_COA_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAllCOARecords(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            COAEventRecordsDto result = coaService.getAllCOAEvents(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_COA_EVENTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_COA_EVENTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editCOARecord(@RequestBody COAEventDto coaEventDto) {
        ResponseMessageDto response = null;
        try {
            List<COAEventDto> result = coaService.editCOAEvent(coaEventDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_COA_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_COA_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteCOARecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            coaService.deleteCOAEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_COA_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_COA_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<COAEventDto> result = coaService.getCOAEvent(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_COA_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_COA_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
