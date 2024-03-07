package com.sherina.hajidanumroh.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherina.hajidanumroh.config.dto.request.RoleRequest;
import com.sherina.hajidanumroh.config.dto.response.RoleDataResponse;
import com.sherina.hajidanumroh.config.dto.response.RoleListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.service.impl.RoleImplService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    
    @Autowired
    RoleImplService roleRepo;

    @PostMapping
    public WebResponseBase saveData (@RequestBody RoleRequest RoleModel) {
        return roleRepo.saveData(RoleModel);
    }
    
    @GetMapping
    public RoleListResponse getAll() {
        return roleRepo.getAll();
    }
    
    @GetMapping
    @RequestMapping("/{uid}")
    public RoleDataResponse getById(@PathVariable String uid) {
        return roleRepo.getById(uid);
    }
    
    @PutMapping
    @RequestMapping("/update/{uid}")
    public WebResponseBase updateById(@PathVariable String uid, @RequestBody RoleRequest request) {
        request.setRoleUid(uid);
        
        return roleRepo.updateById(request);
    }

    @DeleteMapping
    @RequestMapping("/delete/{uid}")
    public WebResponseBase deleteById(@PathVariable String uid) {
        return roleRepo.deleteById(uid);
    }
    

}

