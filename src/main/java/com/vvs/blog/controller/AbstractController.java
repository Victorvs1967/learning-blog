 package com.vvs.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vvs.blog.service.BusinessService;
import com.vvs.blog.service.impl.ServiceManager;

public abstract class AbstractController extends HttpServlet {
	
	private static final long serialVersionUID = 3468601774079874667L;

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	private BusinessService businessService;
	
	public final BusinessService getBusinessService() {
		return businessService;
	}
	
	public final int getOffset(HttpServletRequest req, int limit) {

		String val = req.getParameter("page");
		if (val != null) {
			int page = Integer.parseInt(val);
			return (page - 1) * limit;
		} else {
			return 0;
		}
	}
	
	@Override
	public void init() throws ServletException {
		businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	}
	
	public final void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("currentPage", "page/" + jspPage);
		req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
	}

	public final void forwardToFragment(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspPage).forward(req, resp);
	}

}
