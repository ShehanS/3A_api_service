package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.NASConfigDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.NASConfigService;
import com.ncinga.aaa.util.ResponseCode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/nas/record/")
public class NASConfigController {

    @Autowired
    private NASConfigService nasEventService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> addNASRAcord(@Valid @RequestBody NASConfigDto payload, BindingResult result) {
        ResponseMessageDto response = null;
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
           response = new ResponseMessageDto(null, null, errors,  ResponseCode.ADD_NAS_EVENT_FAILED);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        try {
            NASConfigDto res = nasEventService.addNAS(payload);
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
            com.ncinga.aaa.dtos.response.NASConfigDto result = nasEventService.getAllNAS(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_EVENTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_EVENTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editCOARecord(@RequestBody NASConfigDto nasConfigDto) {
        ResponseMessageDto response = null;
        try {
            List<NASConfigDto> result = nasEventService.editNAS(nasConfigDto);
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
            nasEventService.deleteNAS(Integer.parseInt(id));
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
            List<NASConfigDto> result = nasEventService.getNAS(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_EVENT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_EVENT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
