package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {

	public static boolean insert(Reimbursement r) {
		return new ReimbursementDAOImpl().insert(r);
	}
	
	public static boolean update(Reimbursement r) {
		return new ReimbursementDAOImpl().update(r);
	}
	
	public static List<Reimbursement> findAll() {
		return new ReimbursementDAOImpl().findAll();
	}
	
	public static Reimbursement findById(int id) {
		List<Reimbursement> all = new ReimbursementDAOImpl().findAll();
		
		for(Reimbursement r : all) {
			if(r.getId() == id) {
				return r;
			}
		}
		
		return null;
	}
	
}
