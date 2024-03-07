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
import com.sherina.hajidanumroh.config.dto.ServicesResponseModel;
import com.sherina.hajidanumroh.config.dto.request.ServicesRequest;
import com.sherina.hajidanumroh.config.repository.ServicesRepo;

@Service
public class ServicesImplRepo implements ServicesRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(ServicesRequest servicesModel) {
        UUID serviceUid = UUID.randomUUID();
        servicesModel.setServiceUid(serviceUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {servicesModel.getServiceUid(), servicesModel.getServiceDesc(), servicesModel.getPathMenu(), servicesModel.getIconMenu(), servicesModel.getDirIconMenu()};
        jdbcTemplate.update(Constant.Services.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(ServicesRequest servicesModel) {
        Object[] queryParam = new Object[] {servicesModel.getServiceDesc(),  servicesModel.getPathMenu(), servicesModel.getIconMenu(), servicesModel.getDirIconMenu(),  servicesModel.getServiceUid()};
        jdbcTemplate.update(Constant.Services.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String uid) {
        Object[] queryParam = new Object[] {uid};
        jdbcTemplate.update(Constant.Services.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<ServicesResponseModel> getAll() {
        List<ServicesResponseModel> data = jdbcTemplate.query(Constant.Services.GET_ALL, new ServicesListExtractor());
        return data;
    }

    @Override
    public ServicesResponseModel getById(String uid) {
        Object[] queryParam = new Object[] {uid};
        ServicesResponseModel data = jdbcTemplate.query(Constant.Services.GET_BY_ID, new ServicesExtractor(), queryParam);
        return data;
    }

    public static final class ServicesListExtractor implements ResultSetExtractor<List<ServicesResponseModel>> {
        @Override
        public List<ServicesResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<ServicesResponseModel> data = new ArrayList<>();

            while(rs.next()){
                ServicesResponseModel servicesModel = new ServicesResponseModel();

                servicesModel.setServiceUid(rs.getString("serviceUid"));
                servicesModel.setServiceDesc(rs.getString("serviceDesc"));
                servicesModel.setPathMenu(rs.getString("pathMenu"));
                servicesModel.setIconMenu(rs.getString("iconMenu"));
                servicesModel.setDirIconMenu(rs.getString("dirIconMenu"));
                servicesModel.setCreatedAt(rs.getString("createdAt"));
                servicesModel.setUpdatedAt(rs.getString("updatedAt"));

                data.add(servicesModel);
            }
            return data;
        }
    }

    public static final class ServicesExtractor implements ResultSetExtractor<ServicesResponseModel>{
        @Override
        public ServicesResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            ServicesResponseModel servicesModel = new ServicesResponseModel();
            if(rs.next()){
                servicesModel.setServiceUid(rs.getString("serviceUid"));
                servicesModel.setServiceDesc(rs.getString("serviceDesc"));
                servicesModel.setPathMenu(rs.getString("pathMenu"));
                servicesModel.setIconMenu(rs.getString("iconMenu"));
                servicesModel.setDirIconMenu(rs.getString("dirIconMenu"));
                servicesModel.setCreatedAt(rs.getString("createdAt"));
                servicesModel.setUpdatedAt(rs.getString("updatedAt"));

                return servicesModel;
            }
            
            else{
                servicesModel = null;
                return servicesModel;
            }
        }
    }

    
}
