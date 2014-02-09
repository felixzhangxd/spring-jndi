package biz.ezcom.spring.jndi.po;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class User implements RowMapper<User> {
    private Integer id;
    private String  name;
    private String  password;

    public User() {}

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.name + " : " + this.password;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int count = metaData.getColumnCount();
        User user = new User();
        for (int i = 1; i <= count; i++) {
            String columnName = metaData.getColumnName(i);
            if ("id".equals(columnName)) {
                user.setId(rs.getInt(i));
            } else if ("name".equals(columnName)) {
                user.setName(rs.getString(i));
            } else if ("password".equals(columnName)) {
                user.setPassword(rs.getString(i));
            }
        }
        return user;
    }
}
