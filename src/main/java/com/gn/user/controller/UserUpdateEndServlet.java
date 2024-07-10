package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;



@WebServlet(name="userUpdateEnd", urlPatterns = "/user/editEnd")
public class UserUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdateEndServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pw = request.getParameter("user_pw");
		String name =  request.getParameter("user_name");
		User u = new User();
		u.setUser_pw(pw);
		u.setUser_name(name);
		int result = new UserService().updateUser(u, name,pw);
		System.out.println(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
