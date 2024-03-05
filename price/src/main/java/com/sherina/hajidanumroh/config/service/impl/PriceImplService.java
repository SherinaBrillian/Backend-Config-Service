package com.sherina.hajidanumroh.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.config.dto.ResponseModel;
import com.sherina.hajidanumroh.config.dto.request.PriceRequest;
import com.sherina.hajidanumroh.config.dto.response.PriceDataResponse;
import com.sherina.hajidanumroh.config.dto.response.PriceListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.repository.PriceRepo;
import com.sherina.hajidanumroh.config.service.PriceService;

@Service
public class PriceImplService implements PriceService {
    @Autowired
    PriceRepo priceRepo;

    @Override
    public WebResponseBase saveData(PriceRequest priceModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            priceRepo.saveData(priceModel);
            response.setStatus("OK");
            return response;
        }
        catch (DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Price is alredy exist");
        }
    }

    @Override
    public WebResponseBase updateData(PriceRequest priceModel) {
        WebResponseBase response = new WebResponseBase();
        priceRepo.updateData(priceModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String uid) {
        WebResponseBase response = new WebResponseBase();
        priceRepo.deleteData(uid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public PriceListResponse getAll() {
        PriceListResponse response = new PriceListResponse();
        List<ResponseModel> priceModel = priceRepo.getAll();
        response.setStatus("OK");
        response.setData(priceModel);
        return response;
    }

    @Override
    public PriceDataResponse getById(String uid) {
        PriceDataResponse response = new PriceDataResponse();
        ResponseModel priceModel = priceRepo.getById(uid);
        if(priceModel == null)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price Not Found!");
        }
        response.setStatus("OK");
        response.setData(priceModel);
        return response;
    }
    
}
