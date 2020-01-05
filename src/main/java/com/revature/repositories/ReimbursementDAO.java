package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> empId(int id);
	public List<Reimbursement> pending(int id, boolean status);
	public List<Reimbursement> resolved(int id, boolean status);
	public List<Reimbursement> myPending(int id);
	public List<Reimbursement> myResolved(int id);
	public boolean submit(int id, double amount);
	public boolean approve(double amount, int userid, int reimid);
	public List<Reimbursement> singleEmp(int id);
	
}
