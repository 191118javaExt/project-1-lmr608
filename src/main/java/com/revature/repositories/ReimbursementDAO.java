package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getByReimbursementId(int id);
	public List<Reimbursement> getByStatusId(int id);
	public List<Reimbursement> getByUserId(int id);
	public List<Reimbursement> getByStatusAndUserId(int sid, int aid);
	public boolean submitReimbursement(Reimbursement reiumbursement);
	public boolean resolveReimbursement(Reimbursement reiumbursement);
	
}
