package com.sherina.hajidanumroh.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesModel {
    private String serviceUid;
    private String serviceDesc;
    private String pathMenu;
    private String iconMenu; 
    private String dirIconMenu;
    private String createdAt;
    private String updatedAt;
}
