package com.ncinga.aaa.dtos.response;


import com.ncinga.aaa.dtos.NASSubscriberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NASSubscribersRecordDto {
    private List<NASSubscriberDto> records;
    private int count;
}


