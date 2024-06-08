package com.dao;

import com.bean.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NotificationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Notification> findAll() {
        String sql = "SELECT * FROM notifications";
        return jdbcTemplate.query(sql, new NotificationRowMapper());
    }

    public Notification findById(Long id) {
        String sql = "SELECT * FROM notifications WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new NotificationRowMapper());
    }

    public void save(Notification notification) {
        String sql = "INSERT INTO notifications (customerId, message, dateCreated, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, notification.getCustomerId(), notification.getMessage(), notification.getDateCreated(), notification.getStatus());
    }

    public void update(Notification notification) {
        String sql = "UPDATE notifications SET customerId = ?, message = ?, dateCreated = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, notification.getCustomerId(), notification.getMessage(), notification.getDateCreated(), notification.getStatus(), notification.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM notifications WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class NotificationRowMapper implements RowMapper<Notification> {
        @Override
        public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
            Notification notification = new Notification();
            notification.setId(rs.getLong("id"));
            notification.setCustomerId(rs.getLong("customerId"));
            notification.setMessage(rs.getString("message"));
            notification.setDateCreated(rs.getDate("dateCreated"));
            notification.setStatus(rs.getString("status"));
            return notification;
        }
    }
}
