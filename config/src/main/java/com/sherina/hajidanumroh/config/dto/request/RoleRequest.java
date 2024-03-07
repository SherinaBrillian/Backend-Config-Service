package com.sherina.hajidanumroh.config.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    private String roleUid;
    private String roleDesc;
    private String statusUid;
}
