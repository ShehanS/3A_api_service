package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.NASSubscriberDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASSubscribersRecordDto;
import com.ncinga.aaa.entity.NasSubscriberEntity;
import com.ncinga.aaa.interfaces.INASSubscriber;
import com.ncinga.aaa.repository.NASSubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NASSubscriberService implements INASSubscriber {

    @Autowired
    private NASSubscriberRepository nasSubscriberRepository;


    @Override
    public NASSubscriberDto addNASSubscriber(NASSubscriberDto record) {
        NasSubscriberEntity nasSubscriberEntity = record.toEntity(NasSubscriberEntity.class);
        try {
            NasSubscriberEntity result = nasSubscriberRepository.save(nasSubscriberEntity);
            if (result != null) {
                return NASSubscriberDto.fromEntity(result, NASSubscriberDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public NASSubscribersRecordDto getNASSubscribers(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<NasSubscriberEntity> subscriberEntities = nasSubscriberRepository.findAll(pageRequest);
            int count = nasSubscriberRepository.getRecordCount();
            if (subscriberEntities.hasContent()) {
                List<NASSubscriberDto> result = subscriberEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, NASSubscriberDto.class))
                        .collect(Collectors.toList());
                return new NASSubscribersRecordDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NASSubscriberDto> editNASSubscriber(NASSubscriberDto record) {
        try {
            List<NASSubscriberDto> result = new ArrayList<>();
            NasSubscriberEntity findRecord = nasSubscriberRepository.findById(record.getSubscriber_id()).orElseThrow();
            findRecord.setSubscriber_id(record.getSubscriber_id());
            findRecord.setAttribute(record.getAttribute());
            findRecord.setOperation(record.getOperation());
            findRecord.setValue(record.getValue());
            findRecord.setAttribute_group(record.getAttribute_group());
            NasSubscriberEntity update = nasSubscriberRepository.save(findRecord);
            NASSubscriberDto updateResult = NASSubscriberDto.fromEntity(update, NASSubscriberDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<NASSubscriberDto> getNASSubscriber(int id) {
        return null;
    }

    @Override
    public void deleteRNASSubscriber(int id) {
        try {
            nasSubscriberRepository.deleteSubscriberIdId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
