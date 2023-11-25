package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.SearchService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/avp")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<ResponseMessageDto> search(@RequestParam(name = "table") String table, @RequestParam(name = "query") String query, @RequestParam(name = "columns") String columns) {
        ResponseMessageDto response = null;
        try {
            Object result = searchService.search(table, columns, query);
            response = new ResponseMessageDto(result, null, null, ResponseCode.SEARCH_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.SEARCH_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
