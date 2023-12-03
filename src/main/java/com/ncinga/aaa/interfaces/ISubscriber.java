package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.SubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;

import java.util.List;

public interface ISubscriber {
    SubscriberDto addSubscriber(SubscriberDto subscribe);

    SubscriberRecordsDto getAllSubscribers(PaginationRequestDto paginationRequestDto);

    List<SubscriberDto> editSubscriber(SubscriberDto record);

    List<SubscriberDto> getSubscriber(int id);

    void deleteSubscriber(int id);

}
