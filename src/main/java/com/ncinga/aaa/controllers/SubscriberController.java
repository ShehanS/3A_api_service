package com.ncinga.aaa.controllers;

import com.ncinga.aaa.dtos.NASWhitelistDto;
import com.ncinga.aaa.dtos.SubscriberDto;
import com.ncinga.aaa.dtos.SubscriberParameterDto;
import com.ncinga.aaa.dtos.SubscriberPlanDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ResponseMessageDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;
import com.ncinga.aaa.services.SubscriberService;
import com.ncinga.aaa.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/subscribers")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessageDto> add(@RequestBody SubscriberDto payload) {
        ResponseMessageDto response = null;
        try {
            SubscriberDto result = subscriberService.addSubscriber(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseMessageDto> getAll(@RequestBody PaginationRequestDto paginationRequestDto) {
        ResponseMessageDto response = null;
        try {
            SubscriberRecordsDto result = subscriberService.getAllSubscribers(paginationRequestDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessageDto> edit(@RequestBody SubscriberDto record) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberDto> result = subscriberService.editSubscriber(record);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            subscriberService.deleteSubscriber(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseMessageDto> get(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberDto> result = subscriberService.getSubscriber(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_SUBSCRIBER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_SUBSCRIBER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //////////////////


    @PostMapping("/nas/whitelist/add-nas")
    public ResponseEntity<ResponseMessageDto> addNas(@RequestBody NASWhitelistDto payload) {
        ResponseMessageDto response = null;
        try {
            NASWhitelistDto result = subscriberService.addNas(payload);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_NAS_WIHITELIST_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_NAS_WIHITELIST_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nas/whitelist/{id}/all")
    public ResponseEntity<ResponseMessageDto> getAllNAS(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<NASWhitelistDto> result = subscriberService.getNasWhitelist(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_WIHITELIST_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_WIHITELIST_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/nas/whitelist/delete")
    public ResponseEntity<ResponseMessageDto> deleteNAS(@RequestBody NASWhitelistDto nasWhitelistDto) {
        ResponseMessageDto response = null;
        try {
            subscriberService.deleteNas(nasWhitelistDto);
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_NAS_WIHITELIST_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_NAS_WIHITELIST_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nas/whitelist/id/{id}")
    public ResponseEntity<ResponseMessageDto> getNas(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<NASWhitelistDto> result = subscriberService.getNasById(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_NAS_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_NAS_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    ////////////


    @PostMapping("/parameter/add")
    public ResponseEntity<ResponseMessageDto> addParameter(@RequestBody SubscriberParameterDto subscriberParameterDto) {
        ResponseMessageDto response = null;
        try {
            SubscriberParameterDto result = subscriberService.addParameter(subscriberParameterDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_SUBSCRIBER_PARAMETER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_SUBSCRIBER_PARAMETER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/parameter/id/{id}/all")
    public ResponseEntity<ResponseMessageDto> getAllParameter(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberParameterDto> result = subscriberService.getParameters(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_SUBSCRIBER_PARAMETER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_SUBSCRIBER_PARAMETER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/parameter/delete")
    public ResponseEntity<ResponseMessageDto> deleteParameter(@RequestBody SubscriberParameterDto subscriberParameterDto) {
        ResponseMessageDto response = null;
        try {
            subscriberService.deleteParameter(subscriberParameterDto);
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_SUBSCRIBER_PARAMETER_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_SUBSCRIBER_PARAMETER_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //////////////////////////


    @PostMapping("/plan/add")
    public ResponseEntity<ResponseMessageDto> addSubscriberPlan(@RequestBody SubscriberPlanDto subscriberPlanDto) {
        ResponseMessageDto response = null;
        try {
            SubscriberPlanDto result = subscriberService.addPlan(subscriberPlanDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.ADD_SUBSCRIBER_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.ADD_SUBSCRIBER_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/plan/id/{subscriberId}/all")
    public ResponseEntity<ResponseMessageDto> getSubscriberAllPlan(@PathVariable int subscriberId) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberPlanDto> result = subscriberService.getAllPlans(subscriberId);
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_ALL_SUBSCRIBER_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_ALL_SUBSCRIBER_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/plan/edit")
    public ResponseEntity<ResponseMessageDto> planSubscriberEdit(@RequestBody SubscriberPlanDto subscriberPlanDto) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberPlanDto> result = subscriberService.editPlan(subscriberPlanDto);
            response = new ResponseMessageDto(result, null, null, ResponseCode.EDIT_SUBSCRIBER_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.EDIT_SUBSCRIBER_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/plan/delete/id/{id}")
    public ResponseEntity<ResponseMessageDto> planSubscriberDelete(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            subscriberService.deletePlan(Integer.parseInt(id));
            response = new ResponseMessageDto(null, null, null, ResponseCode.DELETE_SUBSCRIBER_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.DELETE_SUBSCRIBER_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/plan/id/{id}")
    public ResponseEntity<ResponseMessageDto> getSubscriberPlan(@PathVariable String id) {
        ResponseMessageDto response = null;
        try {
            List<SubscriberPlanDto> result = subscriberService.getPlan(Integer.parseInt(id));
            response = new ResponseMessageDto(result, null, null, ResponseCode.GET_SUBSCRIBER_PLAN_SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseMessageDto(null, null, e.getMessage(), ResponseCode.GET_SUBSCRIBER_PLAN_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
