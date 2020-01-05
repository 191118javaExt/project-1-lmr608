package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.CloseStreams;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);
	
	@Override
	public boolean insert(Reimbursement r) {

		PreparedStatement stmt = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO projectfun.ers_reimbursement (REIMB_AMOUNT, REIMB_TYPE_ID) " +
					"VALUES (?, ?);";
			
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getTypeId());
			
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
	public boolean update(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reimbursement> findAll() {
		
		List<Reimbursement> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.ers_reimbursement;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("REIMB_RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("REIMB_AUTHOR");
				int resolverId = rs.getInt("REIMB_RESOLVER");
				boolean approved = rs.getBoolean("REIMB_STATUS_ID");
				int typeId = rs.getInt("REIMB_TYPE_ID");
				
				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, authorId, resolverId, approved, typeId);
				list.add(r);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		
		return list;
	}

}
