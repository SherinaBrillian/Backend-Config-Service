package com.sherina.hajidanumroh.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseModel {
    private String roleUid;
    private String roleDesc;
    private String statusUid;
}
