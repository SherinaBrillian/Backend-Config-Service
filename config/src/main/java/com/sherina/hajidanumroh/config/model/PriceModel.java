package com.sherina.hajidanumroh.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceModel {
    private String priceUid;
    private Long price;
    private String productName;
    private String productUid;
}
