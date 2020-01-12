package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.USER;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int uid = rs.getInt("USER_ID");
				String ufirst_name = rs.getString("FIRST_NAME");
				String ulast_name = rs.getString("LAST_NAME");
				String uusername = rs.getString("USERNAME");
				String upassword = rs.getString("PASSWORD");
				String uemail = rs.getString("EMAIL");
				int uroleId = rs.getInt("ROLE_ID");
				
				User u = new User(uid, ufirst_name, ulast_name, uusername, upassword, uemail, uroleId);
				list.add(u);
			}
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User login(String username, String password) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.users WHERE username = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int uid = rs.getInt("USER_ID");
				String ufirst_name = rs.getString("FIRST_NAME");
				String ulast_name = rs.getString("LAST_NAME");
				String uusername = rs.getString("USERNAME");
				String upassword = rs.getString("PASSWORD");
				String uemail = rs.getString("EMAIL");
				int uroleId = rs.getInt("ROLE_ID");
				
				User u = new User(uid, ufirst_name, ulast_name, uusername, upassword, uemail, uroleId);
				return u;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get User from database", e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getByUsername(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.users WHERE username = ? AND password = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int uid = rs.getInt("USER_ID");
				String ufirst_name = rs.getString("FIRST_NAME");
				String ulast_name = rs.getString("LAST_NAME");
				String uusername = rs.getString("USERNAME");
				String upassword = rs.getString("PASSWORD");
				String uemail = rs.getString("EMAIL");
				int uroleId = rs.getInt("ROLE_ID");
				
				User u = new User(uid, ufirst_name, ulast_name, uusername, upassword, uemail, uroleId);
				return u;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get User from database", e);
			e.printStackTrace();
		}
		return null;
	}

}
