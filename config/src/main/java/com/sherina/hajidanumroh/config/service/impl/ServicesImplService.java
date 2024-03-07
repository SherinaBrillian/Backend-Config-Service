package com.sherina.hajidanumroh.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.config.dto.ServicesResponseModel;
import com.sherina.hajidanumroh.config.dto.request.ServicesRequest;
import com.sherina.hajidanumroh.config.dto.response.ServicesDataResponse;
import com.sherina.hajidanumroh.config.dto.response.ServicesListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.repository.ServicesRepo;
import com.sherina.hajidanumroh.config.service.ServicesService;

@Service
public class ServicesImplService implements ServicesService {
    @Autowired
    ServicesRepo servicesRepo;

    @Override
    public WebResponseBase saveData(ServicesRequest servicesModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            servicesRepo.saveData(servicesModel);
            response.setStatus("OK");
            return response;
        }
        catch (DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "OK");
        }
    }

    @Override
    public WebResponseBase updateData(ServicesRequest servicesModel) {
        WebResponseBase response = new WebResponseBase();
        servicesRepo.updateData(servicesModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String uid) {
        WebResponseBase response = new WebResponseBase();
        servicesRepo.deleteData(uid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public ServicesListResponse getAll() {
        ServicesListResponse response = new ServicesListResponse();
        List<ServicesResponseModel> servicesModel = servicesRepo.getAll();
        response.setStatus("OK");
        response.setData(servicesModel);
        return response;
    }

    @Override
    public ServicesDataResponse getById(String uid) {
        ServicesDataResponse response = new ServicesDataResponse();
        ServicesResponseModel servicesModel = servicesRepo.getById(uid);
        if(servicesModel == null)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Services Not Found!");
        }
        response.setStatus("OK");
        response.setData(servicesModel);
        return response;
    }
    
    
}

