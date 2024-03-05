package com.sherina.hajidanumroh.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MappingRoleServiceModel {
    private String mappingUid;
    private String roleUid;
    private String serviceUid;
    private String status;
    private String permission;
}
