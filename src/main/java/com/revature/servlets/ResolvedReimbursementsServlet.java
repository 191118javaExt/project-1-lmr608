package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ReimbursementService;

public class ResolvedReimbursementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1745272828534897368L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ReimbursementService rs = new ReimbursementService();
		int statusId = Integer.parseInt(session.getAttribute("status_id").toString());
		rs.getByStatusId(statusId);
		resp.getWriter().write((new ObjectMapper()).writeValueAsString(rs.getByStatusId(statusId)));	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}