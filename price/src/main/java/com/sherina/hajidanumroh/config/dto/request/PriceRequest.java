package com.sherina.hajidanumroh.config.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
    private String priceUid;
    private Long price;
    private String productName;
    private String productUid;
}
