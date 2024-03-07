package com.sherina.hajidanumroh.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.config.dto.RoleResponseModel;
import com.sherina.hajidanumroh.config.dto.request.RoleRequest;
import com.sherina.hajidanumroh.config.dto.response.RoleDataResponse;
import com.sherina.hajidanumroh.config.dto.response.RoleListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.repository.impl.RoleImplRepo;
import com.sherina.hajidanumroh.config.service.RoleService;

@Service
public class RoleImplService implements RoleService{
    @Autowired
    RoleImplRepo roleImpl;

    @Override
    public WebResponseBase saveData(RoleRequest roleModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            roleImpl.saveData(roleModel);
            response.setStatus("OK");
            return response;

        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT,"sudah ada");
        }
    }

    @Override
    public RoleListResponse getAll() {
        RoleListResponse response = new RoleListResponse();
        List<RoleResponseModel> roleModel = roleImpl.getAll();
        response.setStatus("OK");
        response.setData(roleModel);
        return response;
    }

    @Override
    public RoleDataResponse getById(String uid) {
        RoleDataResponse response = new RoleDataResponse();
        RoleResponseModel roleModel = roleImpl.getById(uid);
        if (roleModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tidak Ditemukan");
        }
        response.setStatus("OK");
        response.setData(roleModel);
        return response;
    }

    @Override
    public WebResponseBase updateById(RoleRequest roleModel) {
        WebResponseBase response = new WebResponseBase();
        roleImpl.updateById(roleModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteById(String uid) {
        WebResponseBase response = new WebResponseBase();
        roleImpl.deleteById(uid);
        response.setStatus("OK");
        return response;
    }

    
}
