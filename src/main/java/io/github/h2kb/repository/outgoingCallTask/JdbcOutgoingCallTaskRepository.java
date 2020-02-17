package io.github.h2kb.repository.outgoingCallTask;

import io.github.h2kb.model.DeliveryOrder;
import io.github.h2kb.model.OutgoingCallTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class JdbcOutgoingCallTaskRepository implements OutgoingCallTaskRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Iterable<OutgoingCallTask> findAll() {
        return jdbc.query("SELECT id, delivery_order_id, create_at FROM outgoing_call_task WHERE active = 'YES'", this::mapRowToOutgoingCallTask);
    }

    @Override
    public int addOutgoingCallTask(Long orderNumberId) {
        return jdbc.update("INSERT INTO outgoing_call_task (delivery_order_id, create_at, active) VALUES (?, ?, ?)", orderNumberId, new Date(), "YES");
    }

    @Override
    public OutgoingCallTask findByDeliveryOrderNumberId(Long orderNumberId) {
        return jdbc.queryForObject("SELECT id, delivery_order_id, create_at FROM outgoing_call_task WHERE delivery_order_id = ? AND active = 'YES'", this::mapRowToOutgoingCallTask, orderNumberId);
    }


    private OutgoingCallTask mapRowToOutgoingCallTask(ResultSet resultSet, int rowNum) throws SQLException {
        return new OutgoingCallTask(resultSet.getLong("id"),
                resultSet.getTimestamp("create_at"),
                resultSet.getLong("delivery_order_id"));
    }
}
