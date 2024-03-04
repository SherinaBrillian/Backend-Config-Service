package com.sherina.hajidanumroh.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherina.hajidanumroh.price.dto.request.PriceRequest;
import com.sherina.hajidanumroh.price.dto.response.PriceDataResponse;
import com.sherina.hajidanumroh.price.dto.response.PriceListResponse;
import com.sherina.hajidanumroh.price.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.price.service.impl.PriceImplService;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    @Autowired
    PriceImplService priceRepo;

    @PostMapping
    public WebResponseBase saveData(@RequestBody PriceRequest priceModel){
        return priceRepo.saveData(priceModel);
    }
    
    @PutMapping
    @RequestMapping("/update/{uid}")
    public WebResponseBase updateData(@PathVariable String uid, @RequestBody PriceRequest request){
        request.setPriceUid(uid);
        return priceRepo.updateData(request);
    }

    @DeleteMapping
    @RequestMapping("/delete/{uid}")
    public WebResponseBase deleteData(@PathVariable String uid){
        return priceRepo.deleteData(uid);
    }

    @GetMapping
    public PriceListResponse getAll(){
        return priceRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/{uid}")
    public PriceDataResponse getById(@PathVariable String uid){
        return priceRepo.getById(uid);
    }
    
}
