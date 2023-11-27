package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.NASAttributeGroupDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASAttributiveGroupRecords;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.NASAttributeGroupService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attribute/group/")
public class NASAttributeGroupController {
    @Autowired
    private NASAttributeGroupService attributeGroupService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody NASAttributeGroupDto payload) {
        ResponseMessageDto response = null;
        try {
            NASAttributeGroupDto result = attributeGroupService.addNASAttributeGroup(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_NAS_ATTRIBUTE_GROUP_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_NAS_ATTRIBUTE_GROUP_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            NASAttributiveGroupRecords result = attributeGroupService.getAllNASAttributeGroup(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_ATTRIBUTE_GROUPS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_ATTRIBUTE_GROUPS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> editC(@RequestBody NASAttributeGroupDto nasAttributeGroupDto) {
        ResponseMessageDto response = null;
        try {
            List<NASAttributeGroupDto> result = attributeGroupService.editNASAttributeGroup(nasAttributeGroupDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_NAS_ATTRIBUTE_GROUP_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_NAS_ATTRIBUTE_GROUP_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteCOARecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            attributeGroupService.deleteNASAttributeGroup(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_NAS_ATTRIBUTE_GROUP_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_NAS_ATTRIBUTE_GROUP_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
