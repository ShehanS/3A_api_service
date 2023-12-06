package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.NASWhitelistDto;
import com.ncinga.aaa.dtos.SubscriberDto;
import com.ncinga.aaa.dtos.SubscriberParameterDto;
import com.ncinga.aaa.dtos.SubscriberPlanDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;

import java.util.List;

public interface ISubscriber {
    SubscriberDto addSubscriber(SubscriberDto subscribe);

    SubscriberRecordsDto getAllSubscribers(PaginationRequestDto paginationRequestDto);

    List<SubscriberDto> editSubscriber(SubscriberDto record);

    List<SubscriberDto> getSubscriber(int id);

    SubscriberParameterDto addParameter(SubscriberParameterDto subscriberParameterDto);

    List<SubscriberParameterDto> editParameter(SubscriberParameterDto subscriberParameterDto);

    List<SubscriberParameterDto> getParameters(int subscriberId);

    List<SubscriberParameterDto> getParameter(int subscriberId);

    void deleteParameter(int id);

    void deleteSubscriber(int id);

    NASWhitelistDto addNas(NASWhitelistDto nasWhitelistDto);

    List<NASWhitelistDto> editNas(NASWhitelistDto nasWhitelistDto);

    List<NASWhitelistDto> getNasWhitelist(int subscriberId);

    List<NASWhitelistDto> getNasById(int subscriberId);

    void deleteNas(NASWhitelistDto nasWhitelistDto);

    //////////////
    SubscriberPlanDto addPlan(SubscriberPlanDto SubscriberPlanDto);

    List<SubscriberPlanDto> editPlan(SubscriberPlanDto nasWhitelistDto);

    List<SubscriberPlanDto> getAllPlans(int subscriberId);

    List<SubscriberPlanDto> getPlan(int instanceId);

    void deletePlan(int instanceId);

}
