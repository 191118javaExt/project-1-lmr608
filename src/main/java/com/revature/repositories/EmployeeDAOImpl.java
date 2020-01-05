package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.utils.CloseStreams;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public boolean insert(Employee e) {
		PreparedStatement stmt = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO project1.ers_users (USER_FIRST_NAME, USER_LAST_NAME, ERS_USERNAME, ERS_PASSWORD, USER_EMAIL, USER_ROLE_ID) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getUsername());
			stmt.setString(4, e.getPassword());
			stmt.setString(5, e.getEmail());
			stmt.setInt(6, e.getRoleId());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all users", ex);
			return false;
		} finally {
			CloseStreams.close(stmt);
		}
		
		return true;
	}

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.ers_users;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ERS_USERS_ID");
				String first_name = rs.getString("USER_FIRST_NAME");
				String last_name = rs.getString("USER_LAST_NAME");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				
				Employee e = new Employee(id, first_name, last_name, username, password, email, roleId);
				list.add(e);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		
		return list;
	}

}
