package com.sherina.hajidanumroh.config.repository;

import java.util.List;

import com.sherina.hajidanumroh.config.dto.RoleResponseModel;
import com.sherina.hajidanumroh.config.dto.request.RoleRequest;

public interface RoleRepo {
    void saveData(RoleRequest roleModel);
    void updateById(RoleRequest roleModel);
    void deleteById(String uid);
    List<RoleResponseModel> getAll();
    RoleResponseModel getById(String uid);
}
