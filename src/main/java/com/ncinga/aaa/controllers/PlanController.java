package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.PlanDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.PlanRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.PlanService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plans/")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody PlanDto payload) {
        ResponseMessageDto response = null;
        try {
            PlanDto result = planService.addPlan(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            PlanRecordsDto result = planService.getAllPlans(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody PlanDto record) {
        ResponseMessageDto response = null;
        try {
            List<PlanDto> result = planService.editPlan(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            planService.deletePlan(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<PlanDto> result = planService.getPlan(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
