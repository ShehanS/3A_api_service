package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.AccountDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AccountRecordsDto;
import com.ncinga.aaa.entity.AccountEntity;
import com.ncinga.aaa.interfaces.IAccount;
import com.ncinga.aaa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccount {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto addAccount(AccountDto record) {
        AccountEntity accountEntity = record.toEntity(AccountEntity.class);
        try {
            AccountEntity result = accountRepository.save(accountEntity);
            if (result != null) {
                return AccountDto.fromEntity(result, AccountDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;

    }

    @Override
    public AccountRecordsDto getAllAccount(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<AccountEntity> accountEntities = accountRepository.findAll(pageRequest);
            int count = accountRepository.getRecordCount();
            if (accountEntities.hasContent()) {
                List<AccountDto> result = accountEntities.getContent().stream()
                        .map(record -> AccountDto.fromEntity(record, AccountDto.class))
                        .collect(Collectors.toList());
                return new AccountRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AccountDto> editAccount(AccountDto record) {
        try {
            List<AccountDto> result = new ArrayList<>();
            AccountEntity findRecord = accountRepository.findById(record.getSubscriber_id()).orElseThrow();
            findRecord.setSubscriber_id(record.getSubscriber_id());
            findRecord.setUsername(record.getUsername());
            findRecord.setAcct_session_id(record.getAcct_session_id());
            findRecord.setNas_ip_address(record.getNas_ip_address());
            findRecord.setFramed_ip_address(record.getFramed_ip_address());
            findRecord.setAcct_status_type(record.getAcct_status_type());
            findRecord.setAcct_input_octets(record.getAcct_input_octets());
            findRecord.setAcct_output_octets(record.getAcct_output_octets());
            findRecord.setFramed_protocol(record.getFramed_protocol());
            findRecord.setAcct_input_gigawords(record.getAcct_input_gigawords());
            findRecord.setAcct_output_gigawords(record.getAcct_output_gigawords());
            findRecord.setNas_port_id(record.getNas_port_id());
            AccountEntity update = accountRepository.save(findRecord);

            AccountDto updateResult = AccountDto.fromEntity(update, AccountDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<AccountDto> getAccount(int id) {
        try {
            List<AccountEntity> accounts = accountRepository.findBySubScriberId(id);

            return accounts.stream()
                    .map(a -> AccountDto.fromEntity(a, AccountDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteAccount(int id) {
        try {
            accountRepository.deleteByAttrGroupId(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete record with id: " + id, e);
        }
    }
}
