package com.sherina.hajidanumroh.config.repository;

import java.util.List;

import com.sherina.hajidanumroh.config.dto.ResponseModel;
import com.sherina.hajidanumroh.config.dto.request.PriceRequest;

public interface PriceRepo {
    void saveData(PriceRequest priceModel);
    void updateData(PriceRequest priceModel);
    void deleteData(String priceUid);
    List<ResponseModel> getAll();
    ResponseModel getById(String priceUid);
}
