package com.ncinga.aaa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequestDto {
    private int subscriberId;
    private int page;
    private int pageSize;
}
