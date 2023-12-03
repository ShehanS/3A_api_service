package com.ncinga.aaa.dtos.response;

import com.ncinga.aaa.dtos.SubscriberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberRecordsDto {
    private List<SubscriberDto> records;
    private int count;
}
