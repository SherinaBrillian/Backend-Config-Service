package com.sherina.hajidanumroh.config.service;

import com.sherina.hajidanumroh.config.dto.request.RoleRequest;
import com.sherina.hajidanumroh.config.dto.response.RoleDataResponse;
import com.sherina.hajidanumroh.config.dto.response.RoleListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;

public interface RoleService {
   WebResponseBase saveData(RoleRequest roleRequest);
    RoleListResponse getAll();
    RoleDataResponse getById(String uid);
    WebResponseBase updateById(RoleRequest roleModel);
    WebResponseBase deleteById(String uid); 
}
