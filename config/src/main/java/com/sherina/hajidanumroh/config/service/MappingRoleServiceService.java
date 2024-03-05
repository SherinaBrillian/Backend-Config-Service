package com.sherina.hajidanumroh.config.service;

import com.sherina.hajidanumroh.config.dto.request.MappingRoleServiceRequest;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceDataResponse;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;

public interface MappingRoleServiceService {
    WebResponseBase saveData(MappingRoleServiceRequest mappingRequest);
    WebResponseBase updateData(MappingRoleServiceRequest mappingRequest);
    WebResponseBase deleteData(String mappingUid);
    MappingRoleServiceListResponse getAll();
    MappingRoleServiceDataResponse getById(String mappingUid);
}
