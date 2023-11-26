package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.COAEventRecordsDto;
import com.ncinga.aaa.entity.COAEventEntity;
import com.ncinga.aaa.interfaces.ICOA;
import com.ncinga.aaa.repository.COARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class COAService implements ICOA {
    @Autowired
    private COARepository coaRepository;

    @Override
    public COAEventDto addCOAEvent(COAEventDto record) {
        COAEventEntity coaEventEntity = record.toEntity(COAEventEntity.class);
        try {
            COAEventEntity result = coaRepository.save(coaEventEntity);
            if (result != null) {
                return COAEventDto.fromEntity(result, COAEventDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public COAEventRecordsDto getAllCOAEvents(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<COAEventEntity> coaEventEntities = coaRepository.findAll(pageRequest);
            int count = coaRepository.getRecordCount();
            if (coaEventEntities.hasContent()) {
                List<COAEventDto> result = coaEventEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, COAEventDto.class))
                        .collect(Collectors.toList());
                return new COAEventRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<COAEventDto> editCOAEvent(COAEventDto record) {
        try {
            List<COAEventDto> result = new ArrayList<>();
            COAEventEntity findRecord = coaRepository.findById(record.getEvent_id()).orElseThrow();
            findRecord.setEvent_id(record.getEvent_id());
            findRecord.setStatus(record.getStatus());
            findRecord.setUsername(record.getUsername());
            COAEventEntity update = coaRepository.save(findRecord);
            COAEventDto updateResult = AVPRecordDto.fromEntity(update, COAEventDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COAEventDto> getCOAEvent(int id) {
        try {
            List<COAEventEntity> records = coaRepository.findByEventId(id);

            return records.stream().map(r -> COAEventDto.fromEntity(r, COAEventDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteCOAEvent(int id) {
        try {
            coaRepository.deleteByEventId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
