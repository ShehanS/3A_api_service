package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.PlanTypeDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanTypeRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.PlanTypeService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plan/types")
public class PlanTypeController {
    @Autowired
    private PlanTypeService planTypeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody PlanTypeDto payload) {
        ResponseMessageDto response = null;
        try {
            PlanTypeDto result = planTypeService.addPlanType(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_PLAN_TYPE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_PLAN_TYPE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            PlanTypeRecordsDto result = planTypeService.getAllPlanType(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_PLAN_TYPE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_PLAN_TYPE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody PlanTypeDto record) {
        ResponseMessageDto response = null;
        try {
            List<PlanTypeDto> result = planTypeService.editPlanType(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_PLAN_TYPE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_PLAN_TYPE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            planTypeService.deletePlanType(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_PLAN_TYPE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_PLAN_TYPE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<PlanTypeDto> result = planTypeService.getPlanType(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_PLAN_TYPE_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_PLAN_TYPE_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
