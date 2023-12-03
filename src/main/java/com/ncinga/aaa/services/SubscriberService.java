package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.ParameterSQLDto;
import com.ncinga.aaa.dtos.PlanTypeDto;
import com.ncinga.aaa.dtos.SubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;
import com.ncinga.aaa.entity.SubscriberEntity;
import com.ncinga.aaa.interfaces.ISubscriber;
import com.ncinga.aaa.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService implements ISubscriber {
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public SubscriberDto addSubscriber(SubscriberDto subscribe) {
        SubscriberEntity subscriberEntity = subscribe.toEntity(SubscriberEntity.class);
        try {

            SubscriberEntity result = subscriberRepository.save(subscriberEntity);
            if (result != null) {
                return SubscriberDto.fromEntity(result, SubscriberDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public SubscriberRecordsDto getAllSubscribers(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<SubscriberEntity> subscriberEntities = subscriberRepository.findAll(pageRequest);
            int count = subscriberRepository.getRecordCount();
            if (subscriberEntities.hasContent()) {
                List<SubscriberDto> result = subscriberEntities.getContent().stream()
                        .map(record -> ParameterSQLDto.fromEntity(record, SubscriberDto.class))
                        .collect(Collectors.toList());
                return new SubscriberRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubscriberDto> editSubscriber(SubscriberDto record) {
        try {
            List<SubscriberDto> result = new ArrayList<>();
            SubscriberEntity findRecord = subscriberRepository.findById(record.getSubscriber_id()).orElseThrow();
            findRecord.setUsername(record.getUsername());
            findRecord.setPassword(record.getPassword());
            findRecord.setStatus(record.getStatus());
            findRecord.setEmail(record.getEmail());
            findRecord.setContact_no(record.getContact_no());
            SubscriberEntity update = subscriberRepository.save(findRecord);
            SubscriberDto updateResult = ParameterSQLDto.fromEntity(update, SubscriberDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<SubscriberDto> getSubscriber(int id) {
        try {
            List<SubscriberEntity> records = subscriberRepository.findBySubscriberId(id);
            return records.stream().map(r -> PlanTypeDto.fromEntity(r, SubscriberDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteSubscriber(int id) {
        try {
            subscriberRepository.deleteBySubscriberId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
