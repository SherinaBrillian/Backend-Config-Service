package com.sherina.hajidanumroh.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MappingRoleServiceResponseModel {
    private String mappingUid;
    private String roleUid;
    private String serviceUid;
    private String status;
    private String permission;
}
