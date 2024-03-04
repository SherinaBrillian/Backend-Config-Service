package com.sherina.hajidanumroh.price.service;

import com.sherina.hajidanumroh.price.dto.request.PriceRequest;
import com.sherina.hajidanumroh.price.dto.response.PriceDataResponse;
import com.sherina.hajidanumroh.price.dto.response.PriceListResponse;
import com.sherina.hajidanumroh.price.dto.response.WebResponseBase;

public interface PriceService {
    WebResponseBase saveData(PriceRequest priceModel);
    WebResponseBase updateData(PriceRequest priceModel);
    WebResponseBase deleteData(String uid);
    PriceListResponse getAll();
    PriceDataResponse getById(String uid);
}
