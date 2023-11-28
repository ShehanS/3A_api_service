package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.ParameterMetaDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ParameterMetaRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.ParameterMetaService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/parameter/meta")
public class ParameterMetaController {
    @Autowired
    private ParameterMetaService parameterMetaService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody ParameterMetaDto payload) {
        ResponseMessageDto response = null;
        try {
            ParameterMetaDto result = parameterMetaService.addParameterMeta(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_PARAMETER_META_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_PARAMETER_META_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            ParameterMetaRecordsDto result = parameterMetaService.getParametersMeta(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_PARAMETER_META_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_PARAMETER_META_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody ParameterMetaDto record) {
        ResponseMessageDto response = null;
        try {
            List<ParameterMetaDto> result = parameterMetaService.editParameterMeta(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_PARAMETER_META_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_PARAMETER_META_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            parameterMetaService.deleteParameterMeta(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_PARAMETER_META_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_PARAMETER_META_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<ParameterMetaDto> result = parameterMetaService.getParameterMeta(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_PARAMETER_SQL_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_PARAMETER_SQL_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
