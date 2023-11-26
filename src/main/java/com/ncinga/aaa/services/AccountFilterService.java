package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AVPRecordDto;
import com.ncinga.aaa.dtos.AccountFilterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AccountFiltersRecordsDto;
import com.ncinga.aaa.entity.AccountFilterEntity;
import com.ncinga.aaa.interfaces.IAccountFilter;
import com.ncinga.aaa.repository.AccountFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountFilterService implements IAccountFilter {

    @Autowired
    private AccountFilterRepository accountFilterRepository;

    @Override
    public AccountFilterDto addFilter(AccountFilterDto record) {
        AccountFilterEntity accountEntity = record.toEntity(AccountFilterEntity.class);
        try {
            AccountFilterEntity result = accountFilterRepository.save(accountEntity);
            if (result != null) {
                return AccountFilterDto.fromEntity(result, AccountFilterDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public AccountFiltersRecordsDto getFilters(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<AccountFilterEntity> accountEntities = accountFilterRepository.findAll(pageRequest);
            int count = accountFilterRepository.getRecordCount();
            if (accountEntities.hasContent()) {
                List<AccountFilterDto> result = accountEntities.getContent().stream().map(record -> AccountFilterDto.fromEntity(record, AccountFilterDto.class)).collect(Collectors.toList());
                return new AccountFiltersRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AccountFilterDto> editFilter(AccountFilterDto record) {
        try {
            List<AccountFilterDto> result = new ArrayList<>();
            AccountFilterEntity findRecord = accountFilterRepository.findById(record.getAttrgroup_id()).orElseThrow();
            findRecord.setFilter_avp(record.getFilter_avp());
            findRecord.setFilter_for(record.getFilter_for());
            findRecord.setAttrgroup_id(record.getAttrgroup_id());
            findRecord.setFilter_regexp(record.getFilter_regexp());
            AccountFilterEntity update = accountFilterRepository.save(findRecord);
            AccountFilterDto updateResult = AVPRecordDto.fromEntity(update, AccountFilterDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AccountFilterDto getFilter(int id) {
        try {
            List<AccountFilterEntity> records = accountFilterRepository.findByAttributeGroupId(id);
            return (AccountFilterDto) records.stream().map(r -> AccountFilterDto.fromEntity(r, AccountFilterDto.class)).collect(Collectors.toList());


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteFilter(int id) {
        try {
            accountFilterRepository.deleteByAttrGroupId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

