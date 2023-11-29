package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.PlanAttributeDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanAttributeRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.PlanAttributeService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plan/attributes")
public class PlanAttributeController {

    @Autowired
    private PlanAttributeService planAttributeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody PlanAttributeDto payload) {
        ResponseMessageDto response = null;
        try {
            PlanAttributeDto result = planAttributeService.addPlanAttribute(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_PLAN_ATTRIBUTE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_PLAN_ATTRIBUTE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            PlanAttributeRecordsDto result = planAttributeService.getAllPlanAttributes(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_PLAN_ATTRIBUTE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_PLAN_ATTRIBUTE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody PlanAttributeDto record) {
        ResponseMessageDto response = null;
        try {
            List<PlanAttributeDto> result = planAttributeService.editPlanAttribute(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_PLAN_ATTRIBUTE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_PLAN_ATTRIBUTE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            planAttributeService.deletePlanAttribute(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_PLAN_ATTRIBUTE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_PLAN_ATTRIBUTE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<PlanAttributeDto> result = planAttributeService.getPlanAttribute(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_PLAN_ATTRIBUTE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_PLAN_ATTRIBUTE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
