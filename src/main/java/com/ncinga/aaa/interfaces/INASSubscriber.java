package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.NASSubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASSubscribersRecordDto;

import java.util.List;

public interface INASSubscriber {
    NASSubscriberDto addNASSubscriber(NASSubscriberDto record);

    NASSubscribersRecordDto getNASSubscribers(PaginationRequestDto paginationRequestDto);

    List<NASSubscriberDto> editNASSubscriber(NASSubscriberDto record);

    List<NASSubscriberDto> getNASSubscriber(int id);

    void deleteRNASSubscriber(int id);
}

