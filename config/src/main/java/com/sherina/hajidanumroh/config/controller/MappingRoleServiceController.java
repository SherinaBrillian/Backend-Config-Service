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

import com.sherina.hajidanumroh.config.dto.request.MappingRoleServiceRequest;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceDataResponse;
import com.sherina.hajidanumroh.config.dto.response.MappingRoleServiceListResponse;
import com.sherina.hajidanumroh.config.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.config.service.impl.MappingRoleServiceImplService;

@RestController
@RequestMapping("/api/v1/MappingRoleService")
public class MappingRoleServiceController {
    
    @Autowired
    MappingRoleServiceImplService mappingService;

    @PostMapping
    public WebResponseBase saveData(@RequestBody MappingRoleServiceRequest mappingRequest) {
        return mappingService.saveData(mappingRequest);
    }
    
    @PutMapping 
    @RequestMapping("/update/{mappingUid}")
    public WebResponseBase updateData(@PathVariable String mappingUid, @RequestBody MappingRoleServiceRequest mappingRequest) {
        mappingRequest.setMappingUid(mappingUid); 
        return mappingService.updateData(mappingRequest);
    }
    
    @DeleteMapping
    @RequestMapping("/delete/{mappingUid}")
    public WebResponseBase deleteData(@PathVariable String mappingUid) {
        return mappingService.deleteData(mappingUid);
    }
    
    @GetMapping
    public MappingRoleServiceListResponse getAll() {
        return mappingService.getAll();
    }
    
    @GetMapping 
    @RequestMapping("/{mappingUid}")
    public MappingRoleServiceDataResponse getById(@PathVariable String mappingUid) {
        return mappingService.getById(mappingUid);
    }
    
}

