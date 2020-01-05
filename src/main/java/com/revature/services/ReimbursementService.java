package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {

	private ReimbursementDAO rd = new ReimbursementDAOImpl();

	public ReimbursementService() {
		
	}
	
	public List<Reimbursement> pending(int id, boolean approved) {
		return rd.pending(id, approved);
	}
	
	public List<Reimbursement> resolved(int id, boolean approved) {
		return rd.resolved(id, approved);
	}
	
	public List<Reimbursement> myPending(int id) {
		return rd.myPending(id);
	}
	
	public List<Reimbursement> myResolved(int id) {
		return rd.myResolved(id);
	}
	
	public boolean submit(int id,double amount) {
		return rd.submit(id, amount);
	}
	
	
	public boolean approve(double amount, int empid, int reimid) {
		return rd.approve(amount,empid,reimid);
	}
	
	public List<Reimbursement> singleEmp(int id) {
		return rd.singleEmp(id);
	}
	
}
