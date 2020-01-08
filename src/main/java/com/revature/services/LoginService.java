package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.models.Login;
import com.revature.utils.ConnectionUtil;

public class LoginService {

	public Employee checkEmp(Login login) {
		Employee e = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM PROJECT1.EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUsername());
			pstmt.setString(2, login.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = (rs.getInt("USER_ID"));
				String firstName = (rs.getString("FIRST_NAME"));
				String lastName = (rs.getString("LAST_NAME"));
				String username = (rs.getString("USERNAME"));
				String password = (rs.getString("PASSWORD"));
				String email = (rs.getString("EMAIL"));
				int roleId = (rs.getInt("ROLE_ID"));
				e = new Employee(id,firstName, lastName, username, password, email, roleId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
}
