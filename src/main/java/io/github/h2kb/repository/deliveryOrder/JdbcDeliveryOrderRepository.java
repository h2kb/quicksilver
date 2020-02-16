package io.github.h2kb.repository.deliveryOrder;

import io.github.h2kb.model.DeliveryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcDeliveryOrderRepository implements DeliveryOrderRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public DeliveryOrder findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM delivery_order WHERE id = ?", this::mapRowToDeliveryOrder, id);
    }

    @Override
    public DeliveryOrder findByOrderNumber(String orderNumber) {
        return jdbc.queryForObject("SELECT * FROM delivery_order WHERE order_number = ?", this::mapRowToDeliveryOrder, orderNumber);
    }

    private DeliveryOrder mapRowToDeliveryOrder(ResultSet resultSet, int rowNum) throws SQLException {
        return new DeliveryOrder(resultSet.getLong("id"),
                resultSet.getString("order_number"),
                resultSet.getLong("customer_id"));
    }
}
