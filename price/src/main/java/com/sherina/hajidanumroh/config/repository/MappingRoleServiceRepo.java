package com.sherina.hajidanumroh.config.repository;

import java.util.List;

import com.sherina.hajidanumroh.config.dto.MappingRoleServiceResponseModel;
import com.sherina.hajidanumroh.config.dto.request.MappingRoleServiceRequest;

public interface MappingRoleServiceRepo {
    void saveData (MappingRoleServiceRequest mappingRequest);
    void updateData (MappingRoleServiceRequest mappingRequest);
    void deleteData(String mappingUid);
    List<MappingRoleServiceResponseModel> getAll();
    MappingRoleServiceResponseModel getById(String mappingUid);
}
