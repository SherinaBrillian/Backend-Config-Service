package com.sherina.hajidanumroh.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleModel {
    private String roleUid;
    private String roleDesc;
    private String statusUid;
}
