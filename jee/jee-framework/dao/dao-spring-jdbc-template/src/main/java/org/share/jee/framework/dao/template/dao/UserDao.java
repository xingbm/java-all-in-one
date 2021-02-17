package org.share.jee.framework.dao.template.dao;

import com.sun.org.apache.regexp.internal.RE;
import org.share.jee.framework.dao.template.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xingbm on 2021/2/17 12:04
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer count() {
        Integer rowCount = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        return rowCount;
    }

    public Integer countWithParam(Integer departmentId) {
        Integer rowCount = jdbcTemplate.queryForObject
                ("select count(*) from user where department_id=?", Integer.class, departmentId);

        String sql = "select count(1) from user where department_id=:departmentId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("departmentId", departmentId);
        rowCount = namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, Integer.class);

        return rowCount;
    }

    /**
     * exception org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
     * @param userId
     * @return
     */
    public User getUser(Integer userId) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setDepartmentId(rs.getInt("department_id"));
                user.setCreateTime(rs.getDate("create_time").toLocalDate());
                return user;
            }
        }, userId);
        return user;
    }

    public int update(User user) {
        String sql = "update user set name=?, department_id=? where id=?";
        int updateCount = jdbcTemplate.update(sql, user.getName(), user.getDepartmentId(), user.getId());

        sql = "update user set name=:name, department_id=:departmentId where id=:id";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        updateCount = namedParameterJdbcTemplate.update(sql, sqlParameterSource);

        return updateCount;
    }

    public Integer insert(User user) {
        String sql = "insert into user (name, department_id) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, user.getName());
                ps.setInt(2, user.getDepartmentId());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}
