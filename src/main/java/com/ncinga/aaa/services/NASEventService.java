package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.NASEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASEventRecordsDto;
import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import com.ncinga.aaa.entity.NASEventEntity;
import com.ncinga.aaa.interfaces.INASEvent;
import com.ncinga.aaa.repository.NASAttributeGroupRepository;
import com.ncinga.aaa.repository.NASEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NASEventService implements INASEvent {

    @Autowired
    private NASEventRepository nasEventRepository;

    @Autowired
    private NASAttributeGroupRepository nasAttributeGroupRepository;

    @Override
    public NASEventDto addNASEvent(NASEventDto record) {
        try {
            NASAttributeGroupEntity groupEntity = nasAttributeGroupRepository.findByGroupId(Integer.parseInt(record.getNas_attrgroup()))
                    .orElseThrow(() -> new IllegalArgumentException("Invalid group id: " + record.getGroup_id())).get(0);
            nasEventRepository.saveNasEvent(groupEntity.getGroup_id(), record.getNas_name(), Integer.parseInt(record.getNas_attrgroup()), record.getNas_type(), record.getNas_type());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public NASEventRecordsDto getAllNASEvents(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<NASEventEntity> coaEventEntities = nasEventRepository.findAll(pageRequest);
            int count = nasEventRepository.getRecordCount();
            if (coaEventEntities.hasContent()) {
                List<NASEventDto> result = coaEventEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, NASEventDto.class))
                        .collect(Collectors.toList());
                return new NASEventRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NASEventDto> editNASEvent(NASEventDto record) {
        try {
            try {
                nasEventRepository.updateNasEvent(record.getGroup_id(), record.getNas_name(), Integer.parseInt(record.getNas_attrgroup()), record.getNas_type(), record.getNas_type());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            return new ArrayList<>();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<NASEventDto> getNASEvent(int id) {
        try {
            List<NASEventEntity> records = nasEventRepository.findByEventId(id);
            return records.stream().map(r -> COAEventDto.fromEntity(r, NASEventDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteNASEvent(int id) {
        try {
            nasEventRepository.deleteByEventId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
