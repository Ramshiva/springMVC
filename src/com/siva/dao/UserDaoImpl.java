package com.siva.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.siva.model.Login;
import com.siva.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
  @Autowired
  DataSource dataSource;
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  
  
  public void register(User user) {
    String sql = "insert into users values(?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassword(), user.getFirstName(),
    user.getLastName(), user.getEmail(), user.getAddress(), user.getPhone() });
    }
  
    public User validateUser(Login login) {
    String sql = "select * from myusers.users where username='" + login.getUserName() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  }
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUserName(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstName(rs.getString("firstname"));
    user.setLastName(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));
    return user;
  }
}