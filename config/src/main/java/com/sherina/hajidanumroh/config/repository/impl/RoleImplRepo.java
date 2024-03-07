package com.sherina.hajidanumroh.config.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.sherina.hajidanumroh.config.constant.Constant;
import com.sherina.hajidanumroh.config.dto.RoleResponseModel;
import com.sherina.hajidanumroh.config.dto.request.RoleRequest;
import com.sherina.hajidanumroh.config.repository.RoleRepo;

@Service
public class RoleImplRepo implements RoleRepo {
    @Autowired 
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(RoleRequest roleModel) {
        UUID roleUid = UUID.randomUUID();
        roleModel.setRoleUid(roleUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {roleModel.getRoleUid(), roleModel.getRoleDesc(), roleModel.getStatusUid()};
        jdbcTemplate.update(Constant.Role.INSERT_DATA, queryParam);
    }

    @Override
    public void updateById(RoleRequest roleModel) {
        Object[] queryParam = new Object[] {roleModel.getRoleDesc(), roleModel.getStatusUid(), roleModel.getRoleUid()};
        jdbcTemplate.update(Constant.Role.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteById(String uid) {
        Object queryParam = new Object[] {uid};
        jdbcTemplate.update(Constant.Role.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<RoleResponseModel> getAll() {
        List<RoleResponseModel> data = jdbcTemplate.query(Constant.Role.GET_ALL, new RoleListExtractor());

    return data;
    }

    @Override
    public RoleResponseModel getById(String uid) {
        Object[] queryParam = new Object[] {uid};
        RoleResponseModel roleModel = jdbcTemplate.query(Constant.Role.GET_BY_ID, new RoleExtractor(), queryParam );
    return roleModel;
    }
    
   public static final class RoleListExtractor implements ResultSetExtractor<List<RoleResponseModel>> {
     @Override
        public List<RoleResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<RoleResponseModel> data = new ArrayList<>();

            while (rs.next()) {
                RoleResponseModel roleModel = new RoleResponseModel();

                roleModel.setRoleUid(rs.getString("roleUid"));
                roleModel.setRoleDesc(rs.getString("roleDesc"));
                roleModel.setStatusUid(rs.getString("statusUid"));

                data.add(roleModel);
              }
            return data;
            }
   }
   
   public static final class RoleExtractor implements ResultSetExtractor<RoleResponseModel> {
    @Override
        public RoleResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            RoleResponseModel roleModel = new RoleResponseModel();
            if (rs.next()) {
                roleModel.setRoleUid(rs.getString("roleUid"));
                roleModel.setRoleDesc(rs.getString("roleDesc"));
                roleModel.setStatusUid(rs.getString("statusUid"));

                return roleModel;
            }

            else {
                roleModel = null;
                return roleModel;
            }
        }

    }
}

