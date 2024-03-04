package com.sherina.hajidanumroh.price.repository.impl;

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

import com.sherina.hajidanumroh.price.constant.Constant;
import com.sherina.hajidanumroh.price.dto.ResponseModel;
import com.sherina.hajidanumroh.price.dto.request.PriceRequest;
import com.sherina.hajidanumroh.price.repository.PriceRepo;

@Service
public class PriceImplRepo implements PriceRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(PriceRequest priceModel) {
        UUID chatUid = UUID.randomUUID();
        priceModel.setPriceUid(chatUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {priceModel.getPriceUid(), priceModel.getPrice(), priceModel.getProductName(), priceModel.getProductUid()};
        jdbcTemplate.update(Constant.Price.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(PriceRequest priceModel) {
        Object[] queryParam = new Object[] {priceModel.getPrice(), priceModel.getProductName(), priceModel.getProductUid(), priceModel.getPriceUid()};
        jdbcTemplate.update(Constant.Price.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String priceUid) {
        Object[] queryParam = new Object[] {priceUid};
        jdbcTemplate.update(Constant.Price.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<ResponseModel> getAll() {
        List<ResponseModel> data = jdbcTemplate.query(Constant.Price.GET_ALL, new PriceListExtractor());
        return data;
    }

    @Override
    public ResponseModel getById(String priceUid) {
        Object[] queryParam = new Object[] {priceUid};
        ResponseModel data = jdbcTemplate.query(Constant.Price.GET_BY_ID, new PriceExtractor(), queryParam);
        return data;
    }

    //EXTRACTOR
    public static final class PriceListExtractor implements ResultSetExtractor<List<ResponseModel>> {
        @Override
        public List<ResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<ResponseModel> data = new ArrayList<>();

            while(rs.next()){
                ResponseModel priceModel = new ResponseModel();

                priceModel.setPriceUid(rs.getString("priceUid"));
                priceModel.setPrice(rs.getLong("price"));
                priceModel.setProductName(rs.getString("productName"));
                priceModel.setProductUid(rs.getString("productUid"));

                data.add(priceModel);
            }
            return data;
        }

    }

    public static final class PriceExtractor implements ResultSetExtractor<ResponseModel>{
        @Override
        public ResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            ResponseModel priceModel = new ResponseModel();
            if(rs.next()){
                priceModel.setPriceUid(rs.getString("priceUid"));
                priceModel.setPrice(rs.getLong("price"));
                priceModel.setProductName(rs.getString("productName"));
                priceModel.setProductUid(rs.getString("productUid"));
                return priceModel;
            }

            else{
                priceModel = null;
                return priceModel;
            }
        }

    }
    
}
