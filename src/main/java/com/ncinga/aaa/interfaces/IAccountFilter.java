package com.ncinga.aaa.interfaces;

import com.ncinga.aaa.dtos.AccountFilterDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.AccountFiltersRecordsDto;
import com.ncinga.aaa.dtos.response.AccountRecordsDto;

import java.util.List;

public interface IAccountFilter {
    AccountFilterDto addFilter(AccountFilterDto record);

    AccountFiltersRecordsDto getFilters(PaginationRequestDto paginationRequestDto);

    List<AccountFilterDto> editFilter(AccountFilterDto record);

    AccountFilterDto getFilter(int id);

    void deleteFilter(int id);
}
