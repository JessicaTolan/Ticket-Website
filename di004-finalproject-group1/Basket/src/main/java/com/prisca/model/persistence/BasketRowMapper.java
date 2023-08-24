package com.prisca.model.persistence;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prisca.entity.Basket;

public class BasketRowMapper implements RowMapper<Basket> {

	@Override
	public Basket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Basket basket = new Basket();
		basket.setBasketId(rs.getInt("basketId"));
        basket.setUsername(rs.getString("username"));
        basket.setTicketId(rs.getInt("ticketId"));
        basket.setQuantity(rs.getInt("quantity"));
        return basket;
	}

}
