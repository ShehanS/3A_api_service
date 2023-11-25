package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.response.AVERecordsDto;
import com.ncinga.aaa.dtos.AccountDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AccountRecordsDto;

import java.util.List;

public interface IAccount {
    AccountDto addAccount(AccountDto record);

    AccountRecordsDto getAllAccount(PaginationRequestDto paginationRequestDto);

    List<AccountDto> editAccount(AccountDto record);

    List<AccountDto> getAccount(int id);

    void deleteAccount(int id);
}
