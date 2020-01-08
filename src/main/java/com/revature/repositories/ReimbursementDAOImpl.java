package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.utils.CloseStreams;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);

	@Override
	public List<Reimbursement> empId(int id) {
		List<Reimbursement> r1 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				boolean approved = rs.getBoolean("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				r1.add(new Reimbursement(reimId, amount, submitted, resolved, authorId, resolverId, approved, typeId));
				System.out.println(amount);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return r1;
	}

	@Override
	public List<Reimbursement> pending(int id, boolean status) {
		List<Reimbursement> r2 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_ID = ? AND STATUS_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setBoolean(2, status);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				boolean approved = rs.getBoolean("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				r2.add(new Reimbursement(reimId, amount, submitted, resolved, authorId, resolverId, approved, typeId));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r2;
	}

	@Override
	public List<Reimbursement> resolved(int id, boolean status) {
		List<Reimbursement> r3 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_ID = ? AND STATUS_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setBoolean(2, status);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				boolean approved = rs.getBoolean("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				r3.add(new Reimbursement(reimId, amount, submitted, resolved, authorId, resolverId, approved, typeId));
			}
	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r3;
	}

	@Override
	public List<Reimbursement> myPending(int id) {
		List<Reimbursement> r4 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID = 1 AND STATUS_ID = 2 AND USER_ID != ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				boolean approved = rs.getBoolean("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				r4.add(new Reimbursement(reimId, amount, submitted, resolved, authorId, resolverId, approved, typeId));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r4;
	}

	@Override
	public List<Reimbursement> myResolved(int id) {
		List<Reimbursement> r4 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUS_ID = 0 OR STATUS_ID = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				boolean approved = rs.getBoolean("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				r4.add(new Reimbursement(reimId, amount, submitted, resolved, authorId, resolverId, approved, typeId));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r4;
	}

	@Override
	public boolean submit(int id, double amount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENTS (EMP_ID, AMOUNT) VALUES (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, id);
			pstmt.setDouble(2, amount);
			pstmt.executeUpdate();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean resolve(double amount, int userid, int reimid) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = ""; 
			PreparedStatement pstmt = conn.prepareStatement(sql);			

			pstmt.executeUpdate();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimbursement> singleEmp(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
