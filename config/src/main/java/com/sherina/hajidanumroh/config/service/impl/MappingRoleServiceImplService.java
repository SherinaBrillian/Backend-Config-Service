package com.sherina.hajidanumroh.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.config.dto.MappingRoleServiceResponseModel;
import com.sherina.hajidanumroh.config.dto.request.MappingRoleServiceRequest;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceDataResponse;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.repository.MappingRoleServiceRepo;
import com.sherina.hajidanumroh.config.service.MappingRoleServiceService;

@Service
public class MappingRoleServiceImplService implements MappingRoleServiceService{
    @Autowired
    MappingRoleServiceRepo mappingRepo;

    @Override
    public WebResponseBase saveData(MappingRoleServiceRequest mappingRequest) {
        try{
            WebResponseBase response = new WebResponseBase();
            mappingRepo.saveData(mappingRequest);
            response.setStatus("ok");
            return response;
        } catch(DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "sudah ada");
        }
    }

    @Override
    public WebResponseBase updateData(MappingRoleServiceRequest mappingRequest) {
        WebResponseBase response = new WebResponseBase();
        mappingRepo.updateData(mappingRequest);
        response.setStatus("ok");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String mappingUid) {
        WebResponseBase response = new WebResponseBase();
        mappingRepo.deleteData(mappingUid);
        response.setStatus("ok");
        return response;
    }

    @Override
    public MappingRoleServiceListResponse getAll() {
        MappingRoleServiceListResponse response = new MappingRoleServiceListResponse();
        List<MappingRoleServiceResponseModel> mappingRequest = mappingRepo.getAll();
        response.setStatus("ok");
        response.setData(mappingRequest);
        return response;
    }

    @Override
    public MappingRoleServiceDataResponse getById(String mappingUid) {
        MappingRoleServiceDataResponse response = new MappingRoleServiceDataResponse();
        MappingRoleServiceResponseModel mappingRequest = mappingRepo.getById(mappingUid);
        if(mappingRequest == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        response.setStatus("ok");
        response.setData(mappingRequest);
        return response;
    }
    

    
}

