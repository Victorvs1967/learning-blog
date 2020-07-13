package com.vvs.blog.controller.ajax;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vvs.blog.controller.AbstractController;
import com.vvs.blog.entity.Comment;
import com.vvs.blog.form.CommentForm;

@WebServlet("/ajax/comment")
public class NewCommentController extends AbstractController{
	
	private static final long serialVersionUID = -5141998782358587950L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentForm form = null; //TODO Create form from current request
		Comment comment = getBusinessService().createComment(form);
		req.setAttribute("comments", Collections.singleton(comment));
		forwardToFragment("comments.jsp", req, resp);
	}	
}
