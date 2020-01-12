package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {

	private ReimbursementDAO rdao = new ReimbursementDAOImpl();

	public ReimbursementService() {
		
	}
	
	public List<Reimbursement> getAllReimbursements() {
		return rdao.getAllReimbursements();
	}
	
	public List<Reimbursement> getByReimbursementId(int id) {
		return rdao.getByReimbursementId(id);
	}
	
	public List<Reimbursement> getByStatusId(int id) {
		return rdao.getByStatusId(id);
	}
	
	public List<Reimbursement> getByUserId(int id) {
		return rdao.getByUserId(id);
	}
	
	public List<Reimbursement> getByStatusAndUserId(int sid, int aid) {
		return rdao.getByStatusAndUserId(sid, aid);
	}
	
	public boolean submitReimbursement(Reimbursement reiumbursement) {
		return rdao.submitReimbursement(reiumbursement);
	}
	
	public boolean resolveReimbursement(Reimbursement reiumbursement) {
		return rdao.resolveReimbursement(reiumbursement);
	}	
}