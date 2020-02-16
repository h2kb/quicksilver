package io.github.h2kb.repository.customer;

import io.github.h2kb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Customer findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM customer WHERE id = ?", this::mapRowToCustomer, id);
    }

    private Customer mapRowToCustomer(ResultSet resultSet, int rowNum) throws SQLException {
        return new Customer(resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("phone_number"));
    }
}
