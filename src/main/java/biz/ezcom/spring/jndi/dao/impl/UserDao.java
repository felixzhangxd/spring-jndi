package biz.ezcom.spring.jndi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.spring.jndi.dao.api.IUserDao;
import biz.ezcom.spring.jndi.po.User;

@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(final User user) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "INSERT INTO t_user(name,password) VALUES (?,?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(psc, keyHolder);
        user.setId(keyHolder.getKey().intValue());
        return count;
    }
}
