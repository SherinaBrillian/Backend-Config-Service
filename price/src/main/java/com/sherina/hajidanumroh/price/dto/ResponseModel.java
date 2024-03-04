package com.sherina.hajidanumroh.price.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
    private String priceUid;
    private Long price;
    private String productName;
    private String productUid;
    
}
