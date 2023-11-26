package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.AccountDto;
import com.ncinga.aaa.dtos.AccountFilterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AccountFiltersRecordsDto;
import com.ncinga.aaa.dtos.response.AccountRecordsDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.services.AccountFilterService;
import com.ncinga.aaa.services.AccountService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountFilterService accountFilterService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody AccountDto payload) {
        ResponseMessageDto response = null;
        try {
            AccountDto result = accountService.addAccount(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_ACCOUNT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_ACCOUNT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            AccountRecordsDto result = accountService.getAllAccount(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ACCOUNTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ACCOUNTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody AccountDto account) {
        ResponseMessageDto response = null;
        try {
            List<AccountDto> result = accountService.editAccount(account);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_ACCOUNTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_ACCOUNTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            accountService.deleteAccount(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_ACCOUNTS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_ACCOUNTS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> getRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<AccountDto> result = accountService.getAccount(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ACCOUNT_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ACCOUNT_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/filters/add")
    public ResponseEntity<ResponseMessageDto> addFilter(@RequestBody AccountFilterDto filter) {
        ResponseMessageDto response = null;
        try {
            AccountFilterDto result = accountFilterService.addFilter(filter);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_FILTER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_FILTER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/filters/edit")
    public ResponseEntity<ResponseMessageDto> editFilter(@RequestBody AccountFilterDto filter) {
        ResponseMessageDto response = null;
        try {
            List<AccountFilterDto> result = accountFilterService.editFilter(filter);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_FILTER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_FILTER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/filters/all")
    public ResponseEntity<ResponseMessageDto> getAllFilters(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            AccountFiltersRecordsDto result = accountFilterService.getFilters(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_FILTERS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_FILTERS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/filters/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> deleteRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            accountFilterService.deleteFilter(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_FILTER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_FILTER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filters/id/{id}")
    public ResponseEntity<ResponseMessageDto> getFilterRecord(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            AccountFilterDto result = accountFilterService.getFilter(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_FILTERS_FAILED);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_AVP_RECORD_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
