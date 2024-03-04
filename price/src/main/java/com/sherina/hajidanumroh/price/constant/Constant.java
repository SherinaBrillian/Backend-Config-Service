package com.sherina.hajidanumroh.price.constant;

public class Constant {
    public static final class Price {
        public static final String INSERT_DATA = "INSERT INTO tbPrice (priceUid, price, productUid) values (?, ?, ?)";
        public static final String UPDATE_BY_ID = "UPDATE tbPrice set price = ?, productUid = ? where priceUid = ?";
        public static final String DELETE_BY_ID = "DELETE FROM tbPrice where priceUid = ?";
        public static final String GET_ALL = "Select * from tbPrice";
        public static final String GET_BY_ID = "Select * from tbPrice where priceUid = ?";
    }
}
