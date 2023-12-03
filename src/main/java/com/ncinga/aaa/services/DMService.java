package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.DMEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.DMEventRecordsDto;
import com.ncinga.aaa.entity.DMEventEntity;
import com.ncinga.aaa.interfaces.IDM;
import com.ncinga.aaa.repository.DMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DMService implements IDM {
    @Autowired
    private DMRepository DMRepository;

    @Override
    public DMEventDto addDMEvent(DMEventDto record) {
        DMEventEntity DMEventEntity = record.toEntity(DMEventEntity.class);
        try {
            DMEventEntity result = DMRepository.save(DMEventEntity);
            if (result != null) {
                return DMEventDto.fromEntity(result, DMEventDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public DMEventRecordsDto getAllDMEvents(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<DMEventEntity> DMEventEntities = DMRepository.findAll(pageRequest);
            int count = DMRepository.getRecordCount();
            if (DMEventEntities.hasContent()) {
                List<DMEventDto> result = DMEventEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, DMEventDto.class))
                        .collect(Collectors.toList());
                return new DMEventRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<DMEventDto> editDMEvent(DMEventDto record) {
        try {
            List<DMEventDto> result = new ArrayList<>();
            DMEventEntity findRecord = DMRepository.findById(record.getEvent_id()).orElseThrow();
            findRecord.setEvent_id(record.getEvent_id());
            findRecord.setStatus(record.getStatus());
            findRecord.setUsername(record.getUsername());
            DMEventEntity update = DMRepository.save(findRecord);
            DMEventDto updateResult = DMEventDto.fromEntity(update, DMEventDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<DMEventDto> getDMEvent(int id) {
        try {
            List<DMEventEntity> records = DMRepository.findByEventId(id);

            return records.stream().map(r -> DMEventDto.fromEntity(r, DMEventDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteDMEvent(int id) {
        try {
            DMRepository.deleteByEventId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
