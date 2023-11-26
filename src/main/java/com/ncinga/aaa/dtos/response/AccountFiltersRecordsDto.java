package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.AccountFilterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFiltersRecordsDto {
    private List<AccountFilterDto> records;
    private int count;
}
