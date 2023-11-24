package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.SearchRequestDto;
import com.ncinga.aaa.dtos.response.AVERRecordsDto;
import com.ncinga.aaa.entity.AVPRecordEntity;
import com.ncinga.aaa.interfaces.IAVPService;
import com.ncinga.aaa.repository.AVPRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AVPService implements IAVPService {
    @Autowired
    private AVPRecordRepository avpRecordRepository;

    @Override
    public AVPRecordDto addRecord(AVPRecordDto record) {
        AVPRecordEntity avpRecordEntity = record.toEntity(AVPRecordEntity.class);
        try {
            AVPRecordEntity result = avpRecordRepository.save(avpRecordEntity);
            if (result != null) {
                return AVPRecordDto.fromEntity(result, AVPRecordDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;

    }

    @Override
    public AVERRecordsDto getAvpRecords(SearchRequestDto searchRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(searchRequestDto.getPage(), searchRequestDto.getPageSize());
            Page<AVPRecordEntity> avpRecordPage = avpRecordRepository.findAll(pageRequest);
            int count = avpRecordRepository.getRecordCount();
            if (avpRecordPage.hasContent()) {
                List<AVPRecordDto> result = avpRecordPage.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, AVPRecordDto.class))
                        .collect(Collectors.toList());
                return new AVERRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public AVPRecordDto editRecord(AVPRecordDto record) {
        try {
           AVPRecordEntity findRecord = avpRecordRepository.findById(record.getAttrgroup_id()).orElseThrow();
           findRecord.setVp_name(record.getVp_name());
           findRecord.setExtract_regexp(record.getExtract_regexp());
           findRecord.setExtract_sscanf(record.getExtract_sscanf());
           findRecord.setSubstitute_vp(record.getSubstitute_vp());
           AVPRecordEntity updateResult = avpRecordRepository.save(findRecord);
           return AVPRecordDto.fromEntity(updateResult, AVPRecordDto.class);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteRecord(int id) {
        try {
            avpRecordRepository.deleteByAttrGroupId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
