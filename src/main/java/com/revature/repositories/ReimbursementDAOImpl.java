package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> allReimbursements = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.REIMBURSEMENTS;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				String description = rs.getString("DESCRIPTION");
				byte[] receipt = rs.getBytes("RECEIPT");
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				int statusId = rs.getInt("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				
				Reimbursement reimbursement = new Reimbursement(reimId, amount, submitted, resolved, description, receipt, authorId, resolverId, statusId, typeId);
				allReimbursements.add(i, reimbursement);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get all Reimbursements", e);
			e.printStackTrace();
		}
		return allReimbursements;
	}

	@Override
	public List<Reimbursement> getByReimbursementId(int id) {
		
		List<Reimbursement> Reimbursement = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.REIMBURSEMENTS WHERE REIM_ID = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				String description = rs.getString("DESCRIPTION");
				byte[] receipt = rs.getBytes("RECEIPT");
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				int statusId = rs.getInt("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				
				Reimbursement reimbursement = new Reimbursement(reimId, amount, submitted, resolved, description, receipt, authorId, resolverId, statusId, typeId);
				Reimbursement.add(i, reimbursement);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get Reimbursement from ID", e);
			e.printStackTrace();
		}
		return Reimbursement;
	}

	@Override
	public List<Reimbursement> getByStatusId(int id) {
		
		List<Reimbursement> statusReimbursements = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.REIMBURSEMENTS WHERE STATUS_ID = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				String description = rs.getString("DESCRIPTION");
				byte[] receipt = rs.getBytes("RECEIPT");
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				int statusId = rs.getInt("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				
				Reimbursement reimbursement = new Reimbursement(reimId, amount, submitted, resolved, description, receipt, authorId, resolverId, statusId, typeId);
				statusReimbursements.add(i, reimbursement);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get Reimbursements from Status", e);
			e.printStackTrace();
		}
		return statusReimbursements;
	}

	@Override
	public List<Reimbursement> getByUserId(int id) {
		
		List<Reimbursement> userReimbursements = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.REIMBURSEMENTS WHERE USER_ID = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				String description = rs.getString("DESCRIPTION");
				byte[] receipt = rs.getBytes("RECEIPT");
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				int statusId = rs.getInt("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				
				Reimbursement reimbursement = new Reimbursement(reimId, amount, submitted, resolved, description, receipt, authorId, resolverId, statusId, typeId);
				userReimbursements.add(i, reimbursement);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get Reimbursements from User", e);
			e.printStackTrace();
		}
		return userReimbursements;
	}
	
	@Override
	public List<Reimbursement> getByStatusAndUserId(int sid, int aid) {
		
		List<Reimbursement> statusUserReimbursements = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM PROJECT1.REIMBURSEMENTS WHERE STATUS_ID = ? AND WHERE AUTHOR = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setInt(2, aid);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double amount = rs.getDouble("AMOUNT");
				LocalDateTime submitted = rs.getTimestamp("SUBMITTED").toLocalDateTime();
				LocalDateTime resolved = rs.getTimestamp("RESOLVED").toLocalDateTime();
				String description = rs.getString("DESCRIPTION");
				byte[] receipt = rs.getBytes("RECEIPT");
				int authorId = rs.getInt("AUTHOR");
				int resolverId = rs.getInt("RESOLVER");
				int statusId = rs.getInt("STATUS_ID");
				int typeId = rs.getInt("TYPE_ID");
				
				Reimbursement reimbursement = new Reimbursement(reimId, amount, submitted, resolved, description, receipt, authorId, resolverId, statusId, typeId);
				statusUserReimbursements.add(i, reimbursement);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get Reimbursements from Status", e);
			e.printStackTrace();
		}
		return statusUserReimbursements;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean submitReimbursement(Reimbursement reimbursement) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO PROJECT1.REIMBURSEMENTS (AMOUNT, SUBMITTED, RESOLVED, DESCRIPTION, RECEIPT, AUTHOR, RESOLVER, STATUS_ID, TYPE_ID)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			pstmt.setDouble(1, reimbursement.getAmount());
			pstmt.setTimestamp(2, new Timestamp(0, 0, 0, 0, 0, 0, 0));
			pstmt.setTimestamp(3, null);
			pstmt.setString(4, reimbursement.getDescription());
			pstmt.setBytes(5, reimbursement.getReceipt());
			pstmt.setInt(6, reimbursement.getAuthorId());
			pstmt.setInt(7, reimbursement.getResolverId());
			pstmt.setInt(8, reimbursement.getStatusId());
			pstmt.setInt(9, reimbursement.getTypeId());
			
			boolean check = pstmt.execute();
			if (check == false) {
				return true;
			}
		} catch (SQLException e) {
			 logger.warn("Unable to Submit Reimbursement", e);
			 e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean resolveReimbursement(Reimbursement reimbursement) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE PROJECT1.REIMBURSEMENTS SET STATUS_ID = ? WHERE REIM_ID = ?;"; 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getStatusId());
			pstmt.setInt(1, reimbursement.getId());
			
			boolean check = pstmt.execute();
			if(check == false) {
				return true;
			}
		} catch (SQLException e) {
			 logger.warn("Unable to Resolve Reimbursement", e);
			 e.printStackTrace();
		}
		return false;
	}
}