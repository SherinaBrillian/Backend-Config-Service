package com.sherina.hajidanumroh.config.repository;

import java.util.List;

import com.sherina.hajidanumroh.config.dto.ServicesResponseModel;
import com.sherina.hajidanumroh.config.dto.request.ServicesRequest;

public interface ServicesRepo {
    void saveData(ServicesRequest servicesModel);
    void updateData(ServicesRequest servicesModel);
    void deleteData(String uid);
    List<ServicesResponseModel> getAll();
    ServicesResponseModel getById(String uid);
}
