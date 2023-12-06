package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.NASConfigDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import com.ncinga.aaa.entity.NASConfigEntity;
import com.ncinga.aaa.interfaces.INASConfig;
import com.ncinga.aaa.repository.NASAttributeGroupRepository;
import com.ncinga.aaa.repository.NASConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NASConfigService implements INASConfig {

    @Autowired
    private NASConfigRepository nasConfigRepository;


    @Autowired
    private NASAttributeGroupRepository nasAttributeGroupRepository;

    @Override
    @Transactional
    public NASConfigDto addNAS(NASConfigDto record) {
        try {
            NASAttributeGroupEntity group = nasAttributeGroupRepository.findById(record.getNas_attrgroup().getGroup_id()).orElseThrow();
            NASConfigEntity nasConfigEntity = record.toEntity(NASConfigEntity.class);

            NASAttributeGroupEntity a=new NASAttributeGroupEntity();
            nasConfigEntity.setNas_attrgroup(group);

            nasConfigRepository.save(nasConfigEntity);
            //NASConfigEntity saved = nasConfigRepository.save(nasConfigEntity);
            return record;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public com.ncinga.aaa.dtos.response.NASConfigDto getAllNAS(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<NASConfigEntity> nasConfigEntities = nasConfigRepository.findAll(pageRequest);
            int count = nasConfigRepository.getRecordCount();
            if (nasConfigEntities.hasContent()) {
                List<NASConfigDto> result = nasConfigEntities.getContent().stream()
                        .map(record -> NASConfigDto.fromEntity(record, NASConfigDto.class))
                        .collect(Collectors.toList());
                return new com.ncinga.aaa.dtos.response.NASConfigDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NASConfigDto> editNAS(NASConfigDto record) {
        try {
            List<NASConfigDto> result = new ArrayList<>();
            NASConfigEntity findRecord = nasConfigRepository.findById(record.getNas_id()).orElseThrow();
            findRecord.setNas_id(record.getNas_id());
            //findRecord.setNas_attrgroup(record.getNas_attrgroup());
            findRecord.setNas_name(record.getNas_name());
            findRecord.setNas_secret(record.getNas_secret());
            findRecord.setNas_type(record.getNas_type());
            findRecord.setNas_secret(record.getNas_secret());
            NASConfigEntity updateRecord = nasConfigRepository.save(findRecord);
            result.add(NASConfigDto.fromEntity(updateRecord, NASConfigDto.class));
        } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            return new ArrayList<>();

    }

    @Override
    public List<NASConfigDto> getNAS(int id) {
        try {
            List<NASConfigEntity> records = nasConfigRepository.findByEventId(id);
            return records.stream().map(r -> COAEventDto.fromEntity(r, NASConfigDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteNAS(int id) {
        try {
            nasConfigRepository.deleteByEventId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
