package com.sherina.hajidanumroh.price.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceModel {
    private String priceUid;
    private Long price;
    private String productUid;
}
