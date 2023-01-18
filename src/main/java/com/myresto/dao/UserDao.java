package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.myresto.domaine.User;

@Repository
public class UserDao implements IUserDao{

	private JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//Read
	public List<User> getAllUsers(){
		return jdbcTemplate.query("Select * from myresto.user",(resultSet, rowNum) -> {
			return new User(resultSet.getInt("id"),resultSet.getString("mail"),resultSet.getString("username"),resultSet.getString("address"),resultSet.getString("tel"),resultSet.getBoolean("gerant"));
		});
	}
	//Create
	public void createUser(User u) {
		Object[] arguments = new Object[6];
		arguments[0] = u.getMail();
		arguments[1] = u.getPassword();
		arguments[2] = u.getUsername();
		arguments[3] = u.getAddress();
		arguments[4] = u.getTel();
		arguments[5] = u.isGerant();		
		jdbcTemplate.update("INSERT INTO myresto.user(mail,password,username,address,tel,gerant) VALUES(?,PASSWORD('?'),?,?,?,?)",arguments);
	}
	
	//UpdateInfo
	public void updateUser(User u) {
		Object[] arguments = new Object[5];
		arguments[0] = u.getMail();
		arguments[1] = u.getUsername();
		arguments[2] = u.getAddress();
		arguments[3] = u.getTel();
		arguments[4] = u.isGerant();
		jdbcTemplate.update("INSERT INTO myresto.user(mail,password,username,address,tel,gerant) VALUES(?,?,?,?,?,?)",arguments);
	}
	//Login
	public User login(String login, String password) {
		return (User) jdbcTemplate.query("Select id,mail,username,address,tel,gerant from user where username='"+login+"' and password=PASSWORD('"+password+"')",(resultSet, rowNum) -> {
			return new User(resultSet.getInt("id"),resultSet.getString("mail"),resultSet.getString("username"),resultSet.getString("address"),resultSet.getString("tel"),resultSet.getBoolean("gerant"));
		});
		
	}
	
	//Delete
	public void deleteUser(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.user where user.id ="+id);
	}
	
	//ChangePassword
	public void changePassword(User u) {
		
	}
}
