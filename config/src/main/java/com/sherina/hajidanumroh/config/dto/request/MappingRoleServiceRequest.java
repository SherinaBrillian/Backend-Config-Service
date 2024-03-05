package com.sherina.hajidanumroh.config.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MappingRoleServiceRequest {
    private String mappingUid;
    private String roleUid;
    private String serviceUid;
    private String status;
    private String permission;
}
