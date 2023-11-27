package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.NASAttributeGroupDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NASAttributiveGroupRecords {
    private List<NASAttributeGroupDto> records;
    private int count;
}
