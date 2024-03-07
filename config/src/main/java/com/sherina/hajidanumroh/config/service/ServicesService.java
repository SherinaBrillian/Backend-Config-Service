package com.sherina.hajidanumroh.config.service;

import com.sherina.hajidanumroh.config.dto.request.ServicesRequest;
import com.sherina.hajidanumroh.config.dto.response.ServicesDataResponse;
import com.sherina.hajidanumroh.config.dto.response.ServicesListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;

public interface ServicesService {
    WebResponseBase saveData(ServicesRequest servicesModel);
    WebResponseBase updateData(ServicesRequest servicesModel);
    WebResponseBase deleteData(String uid);
    ServicesListResponse getAll();
    ServicesDataResponse getById(String uid);
}
