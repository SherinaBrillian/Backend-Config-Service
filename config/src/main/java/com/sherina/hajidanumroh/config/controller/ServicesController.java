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

import com.sherina.hajidanumroh.config.dto.request.ServicesRequest;
import com.sherina.hajidanumroh.config.dto.response.ServicesDataResponse;
import com.sherina.hajidanumroh.config.dto.response.ServicesListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.service.impl.ServicesImplService;

@RestController
@RequestMapping("/api/v1/Services")
public class ServicesController {
    @Autowired
    ServicesImplService servicesRepo;

    @PostMapping
    public WebResponseBase saveData(@RequestBody ServicesRequest servicesModel){
        return servicesRepo.saveData(servicesModel);
    }
    
    @PutMapping
    @RequestMapping("/update/{uid}")
    public WebResponseBase updateData(@PathVariable String uid, @RequestBody ServicesRequest request){
        request.setServiceUid(uid);
        return servicesRepo.updateData(request);
    }

    @DeleteMapping
    @RequestMapping("/delete/{uid}")
    public WebResponseBase deleteData(@PathVariable String uid){
        return servicesRepo.deleteData(uid);
    }

    @GetMapping
    public ServicesListResponse getAll(){
        return servicesRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/{uid}")
    public ServicesDataResponse getById(@PathVariable String uid){
        return servicesRepo.getById(uid);
    }
}

