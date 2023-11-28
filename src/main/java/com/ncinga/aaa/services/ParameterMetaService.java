package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.ParameterMetaDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ParameterMetaRecordsDto;
import com.ncinga.aaa.entity.ParameterMetaEntity;
import com.ncinga.aaa.interfaces.IParameterMeta;
import com.ncinga.aaa.repository.ParameterMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterMetaService implements IParameterMeta {

    @Autowired
    private ParameterMetaRepository parameterMetaRepository;

    @Override
    public ParameterMetaDto addParameterMeta(ParameterMetaDto record) {
        ParameterMetaEntity parameterMetaEntity = record.toEntity(ParameterMetaEntity.class);
        try {
            ParameterMetaEntity result = parameterMetaRepository.save(parameterMetaEntity);
            if (result != null) {
                return ParameterMetaDto.fromEntity(result, ParameterMetaDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public ParameterMetaRecordsDto getParametersMeta(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<ParameterMetaEntity> parameterSQLEntities = parameterMetaRepository.findAll(pageRequest);
            int count = parameterMetaRepository.getRecordCount();
            if (parameterSQLEntities.hasContent()) {
                List<ParameterMetaDto> result = parameterSQLEntities.getContent().stream().map(record -> AVPRecordDto.fromEntity(record, ParameterMetaDto.class)).collect(Collectors.toList());
                return new ParameterMetaRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ParameterMetaDto> editParameterMeta(ParameterMetaDto record) {
        List<ParameterMetaDto> result = new ArrayList<>();
        ParameterMetaEntity findRecord = parameterMetaRepository.findById(record.getParameter_id()).orElseThrow();
        findRecord.setParameter_id(record.getParameter_id());
        findRecord.setParameter_name(record.getParameter_name());
        findRecord.setParameter_lib_path(record.getParameter_lib_path());
        findRecord.setParameter_status(findRecord.getParameter_status());
        findRecord.setParameter_method_symbol(record.getParameter_method_symbol());
        findRecord.setExec_phase(record.getExec_phase());
        ParameterMetaEntity update = parameterMetaRepository.save(findRecord);
        ParameterMetaDto updateResult = ParameterMetaDto.fromEntity(update, ParameterMetaDto.class);
        result.add(updateResult);
        return result;
    }

    @Override
    public List<ParameterMetaDto> getParameterMeta(int id) {
        try {
            List<ParameterMetaEntity> records = parameterMetaRepository.findByByParameterId(id);
            return records.stream().map(r -> ParameterMetaDto.fromEntity(r, ParameterMetaDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteParameterMeta(int id) {
        try {
            parameterMetaRepository.deleteByParameterId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
