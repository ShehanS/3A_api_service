package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.COAEventDto;
import com.ncinga.aaa.dtos.ParameterSQLDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.ParameterSQLRecordsDto;
import com.ncinga.aaa.entity.ParameterSQLEntity;
import com.ncinga.aaa.interfaces.IParameterSQL;
import com.ncinga.aaa.repository.ParameterSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterSQLService implements IParameterSQL {

    @Autowired
    private ParameterSQLRepository parameterSQLRepository;

    @Override
    public ParameterSQLDto addParameterSQL(ParameterSQLDto record) {
        ParameterSQLEntity parameterSQLEntity = record.toEntity(ParameterSQLEntity.class);
        try {
            ParameterSQLEntity result = parameterSQLRepository.save(parameterSQLEntity);
            if (result != null) {
                return ParameterSQLDto.fromEntity(result, ParameterSQLDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public ParameterSQLRecordsDto getParametersSQL(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<ParameterSQLEntity> parameterSQLEntities = parameterSQLRepository.findAll(pageRequest);
            int count = parameterSQLRepository.getRecordCount();
            if (parameterSQLEntities.hasContent()) {
                List<ParameterSQLDto> result = parameterSQLEntities.getContent().stream()
                        .map(record -> AVPRecordDto.fromEntity(record, ParameterSQLDto.class))
                        .collect(Collectors.toList());
                return new ParameterSQLRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ParameterSQLDto> editParameterSQL(ParameterSQLDto record) {
        try {
            List<ParameterSQLDto> result = new ArrayList<>();
            ParameterSQLEntity findRecord = parameterSQLRepository.findById(record.getAction_id()).orElseThrow();
            findRecord.setAction_sql(record.getAction_sql());
            findRecord.setParameter_name(record.getParameter_name());
            findRecord.setAction_name(record.getAction_name());
            findRecord.setAction_id(findRecord.getAction_id());
            findRecord.setEntity(record.getEntity());
            findRecord.setMatch_return(record.getMatch_return());
            findRecord.setParameter_name(record.getParameter_name());
            ParameterSQLEntity update = parameterSQLRepository.save(findRecord);
            ParameterSQLDto updateResult = ParameterSQLDto.fromEntity(update, ParameterSQLDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ParameterSQLDto> getParameterSQL(int id) {
        try {
            List<ParameterSQLEntity> records = parameterSQLRepository.findByByActionId(id);
            return records.stream().map(r -> COAEventDto.fromEntity(r, ParameterSQLDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteParameterSQL(int id) {
        try {
            parameterSQLRepository.deleteByActionId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
