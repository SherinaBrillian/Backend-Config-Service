package com.sherina.hajidanumroh.config.service;

import com.sherina.hajidanumroh.config.dto.request.PriceRequest;
import com.sherina.hajidanumroh.config.dto.response.PriceDataResponse;
import com.sherina.hajidanumroh.config.dto.response.PriceListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;

public interface PriceService {
    WebResponseBase saveData(PriceRequest priceModel);
    WebResponseBase updateData(PriceRequest priceModel);
    WebResponseBase deleteData(String uid);
    PriceListResponse getAll();
    PriceDataResponse getById(String uid);
}
