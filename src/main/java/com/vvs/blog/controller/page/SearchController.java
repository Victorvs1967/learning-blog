package com.vvs.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vvs.blog.controller.AbstractController;


@WebServlet("/search")
public class SearchController extends AbstractController {

	private static final long serialVersionUID = -6375892977503388942L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("search.jsp", req, resp);
	}

}
