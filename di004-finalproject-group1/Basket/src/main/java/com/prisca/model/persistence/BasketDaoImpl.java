package com.prisca.model.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prisca.entity.Basket;

@Repository
public class BasketDaoImpl implements BasketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Basket> getAllBaskets() {
		String sql = "SELECT * FROM basket";
        return jdbcTemplate.query(sql, new BasketRowMapper());
	}

	@Override
	public void save(Basket basket) {
		String sql = "INSERT INTO basket (basketId, username, ticketId, quantity) VALUES (?,?, ?, ?)";
        jdbcTemplate.update(sql, basket.getBasketId(), basket.getUsername(), basket.getTicketId(), basket.getQuantity());

	}

	@Override
	public void update(Basket basket) {
		String sql = "UPDATE basket SET quantity = ? WHERE ticketId = ?";
      int rowsAffected=  jdbcTemplate.update(sql, basket.getQuantity(), basket.getTicketId());
        if (rowsAffected == 0) {
            // No rows were affected, meaning the Basket with the specified ticketId does not exist.
            throw new EmptyResultDataAccessException(1);
        }

	}

	

	@Override
	public Basket findByTicketId(int ticketId) {
		String sql = "SELECT basketId, username, ticketId, quantity FROM basket WHERE ticketId = ?";
        return jdbcTemplate.queryForObject(sql, new BasketRowMapper(), ticketId);
	}



	@Override
	public List<Basket> getBasketsByUsername(String username) {
	    String sql = "SELECT * FROM basket WHERE username = ?";
	    return jdbcTemplate.query(sql, new BasketRowMapper(), username);
    }

	@Override
	public int deleteBasketById(int ticketId) {
		String sql = "DELETE FROM BASKET WHERE TICKETID = ?";
		return jdbcTemplate.update(sql, ticketId);
	}
	}
	

	


