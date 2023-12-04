package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AVERecordsDto;
import com.ncinga.aaa.entity.AVPRecordEntity;
import com.ncinga.aaa.interfaces.IAVP;
import com.ncinga.aaa.repository.AVPRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AVPService implements IAVP {
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
    public AVERecordsDto getAvpRecords(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<AVPRecordEntity> avpRecordPage = avpRecordRepository.findAll(pageRequest);
            int count = avpRecordRepository.getRecordCount();
            if (avpRecordPage.hasContent()) {
                List<AVPRecordDto> result = avpRecordPage.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, AVPRecordDto.class))
                        .collect(Collectors.toList());
                return new AVERecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AVPRecordDto> editRecord(AVPRecordDto record) {
        try {
            List<AVPRecordDto> result = new ArrayList<>();
            AVPRecordEntity findRecord = avpRecordRepository.findByAttrGroupId(record.getAttrgroup_id()).get(0);
            findRecord.setVp_name(record.getVp_name());
            findRecord.setExtract_regexp(record.getExtract_regexp());
            findRecord.setExtract_sscanf(record.getExtract_sscanf());
            findRecord.setSubstitute_vp(record.getSubstitute_vp());
            AVPRecordEntity update = avpRecordRepository.save(findRecord);
            AVPRecordDto updateResult = AVPRecordDto.fromEntity(update, AVPRecordDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<AVPRecordDto> getRecord(int id) {
        try {
            List<AVPRecordEntity> records = avpRecordRepository.findByAttrGroupId(id);

            return records.stream().map(r -> AVPRecordDto.fromEntity(r, AVPRecordDto.class)).collect(Collectors.toList());

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
            throw new RuntimeException(e.getMessage());
        }
    }

}
