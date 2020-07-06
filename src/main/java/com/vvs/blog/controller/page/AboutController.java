package com.vvs.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vvs.blog.controller.AbstractController;

@WebServlet("/about")
public class AboutController extends AbstractController {

	private static final long serialVersionUID = 4957479282945758532L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("about.jsp", req, resp);
	}
}
