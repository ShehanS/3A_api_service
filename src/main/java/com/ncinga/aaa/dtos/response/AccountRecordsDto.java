package com.ncinga.aaa.dtos.response;


import com.ncinga.aaa.dtos.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRecordsDto {
    private List<AccountDto> records;
    private int count;
}
