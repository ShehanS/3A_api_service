package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.NASAttributeGroupDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASAttributiveGroupRecords;
import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import com.ncinga.aaa.interfaces.INASAttributeGroup;
import com.ncinga.aaa.repository.NASAttributeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NASAttributeGroupService implements INASAttributeGroup {
    @Autowired
    private NASAttributeGroupRepository nasAttributeGroupRepository;

    @Override
    public NASAttributeGroupDto addNASAttributeGroup(NASAttributeGroupDto record) {
        try {
            nasAttributeGroupRepository.saveNasAttributeGroup(record.getGroup_id(), record.getGroup_name(), record.getGroup_description());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public NASAttributiveGroupRecords getAllNASAttributeGroup(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<NASAttributeGroupEntity> nasAttributeGroupEntities = nasAttributeGroupRepository.findAll(pageRequest);
            int count = nasAttributeGroupRepository.getRecordCount();
            if (nasAttributeGroupEntities.hasContent()) {
                List<NASAttributeGroupDto> result = nasAttributeGroupEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, NASAttributeGroupDto.class))
                        .collect(Collectors.toList());
                return new NASAttributiveGroupRecords(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NASAttributeGroupDto> editNASAttributeGroup(NASAttributeGroupDto record) {
        try {
            nasAttributeGroupRepository.updateNasAttributeGroup(record.getGroup_id(), record.getGroup_name(), record.getGroup_description());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;

    }

    @Override
    public List<NASAttributeGroupDto> getNASAttributesGroup(int id) {
        return null;
    }

    @Override
    public void deleteNASAttributeGroup(int id) {
        try {
            nasAttributeGroupRepository.deleteByNASAttributeGroupById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
