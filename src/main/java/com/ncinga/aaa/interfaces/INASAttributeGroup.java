package com.ncinga.aaa.interfaces;


import com.ncinga.aaa.dtos.NASAttributeGroupDto;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.NASAttributiveGroupRecords;

import java.util.List;

public interface INASAttributeGroup {
    NASAttributeGroupDto addNASAttributeGroup(NASAttributeGroupDto record);

    NASAttributiveGroupRecords getAllNASAttributeGroup(PaginationRequestDto paginationRequestDto);

    List<NASAttributeGroupDto> editNASAttributeGroup(NASAttributeGroupDto record);

    List<NASAttributeGroupDto> getNASAttributesGroup(int id);

    void deleteNASAttributeGroup(int id);
}
