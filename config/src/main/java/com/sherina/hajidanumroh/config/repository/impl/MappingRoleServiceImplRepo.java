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
import com.sherina.hajidanumroh.config.dto.MappingRoleServiceResponseModel;
import com.sherina.hajidanumroh.config.dto.request.MappingRoleServiceRequest;
import com.sherina.hajidanumroh.config.repository.MappingRoleServiceRepo;
import com.sherina.hajidanumroh.config.repository.impl.MappingRoleServiceImplRepo.MappingRoleServiceListExtractor.MappingRoleServiceExtractor;

@Service
public class MappingRoleServiceImplRepo implements MappingRoleServiceRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(MappingRoleServiceRequest mappingRequest) {
        UUID mappingUid = UUID.randomUUID();
        mappingRequest.setMappingUid(mappingUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {mappingRequest.getMappingUid(), mappingRequest.getRoleUid(), mappingRequest.getServiceUid(), mappingRequest.getStatus(), mappingRequest.getPermission()};
        jdbcTemplate.update(Constant.MappingRoleService.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(MappingRoleServiceRequest mappingRequest) {
        Object[] queryParam = new Object[] {mappingRequest.getRoleUid(), mappingRequest.getServiceUid(), mappingRequest.getStatus(), mappingRequest.getPermission(), mappingRequest.getMappingUid()};
        jdbcTemplate.update(Constant.MappingRoleService.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String mappingUid) {
        Object[] queryParam = new Object[] {mappingUid};
        jdbcTemplate.update(Constant.MappingRoleService.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<MappingRoleServiceResponseModel> getAll() {
        List<MappingRoleServiceResponseModel> data = jdbcTemplate.query(Constant.MappingRoleService.GET_ALL, new MappingRoleServiceListExtractor());
        return data;
    }

    @Override
    public MappingRoleServiceResponseModel getById(String mappingUid) {
        Object[] queryParam = new Object[] {mappingUid};
        MappingRoleServiceResponseModel data = jdbcTemplate.query(Constant.MappingRoleService.GET_BY_ID, new MappingRoleServiceExtractor(), queryParam);
        return data;
    }


    public static final class MappingRoleServiceListExtractor implements ResultSetExtractor<List<MappingRoleServiceResponseModel>> {
       @Override
       public List<MappingRoleServiceResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<MappingRoleServiceResponseModel> data = new ArrayList<>();

        while (rs.next()) {
            MappingRoleServiceResponseModel mappingResponseModel = new MappingRoleServiceResponseModel();

            mappingResponseModel.setMappingUid(rs.getString("mappingUid"));
            mappingResponseModel.setRoleUid(rs.getString("roleUid"));
            mappingResponseModel.setServiceUid(rs.getString("serviceUid"));
            mappingResponseModel.setStatus(rs.getString("status"));
            mappingResponseModel.setPermission(rs.getString("permission"));

            data.add(mappingResponseModel);
        }
        return data;
    }
    
        
    public static final class MappingRoleServiceExtractor implements ResultSetExtractor<MappingRoleServiceResponseModel> {
        @Override
        public MappingRoleServiceResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            MappingRoleServiceResponseModel mappingResponseModel = new MappingRoleServiceResponseModel();
            if(rs.next()){
                mappingResponseModel.setMappingUid(rs.getString("mappingUid"));
                mappingResponseModel.setRoleUid(rs.getString("roleUid"));
                mappingResponseModel.setServiceUid(rs.getString("serviceUid"));
                mappingResponseModel.setStatus(rs.getString("status"));
                mappingResponseModel.setPermission(rs.getString("permission"));
            return mappingResponseModel;
            }
            else{
                mappingResponseModel = null;
                return mappingResponseModel;
            }
        }
    }
    }
}
