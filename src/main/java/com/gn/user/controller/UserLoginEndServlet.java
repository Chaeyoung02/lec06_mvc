package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;


@WebServlet(name="userLoginEnd", urlPatterns = "/user/loginEnd")
public class UserLoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLoginEndServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//로그인 -> 비밀번호 확인(사용자 입력 == 회원가입)
	//회원가입 비밀번화 암호화 != 사용자 입력 암호화
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		//System.out.println("비밀번호 : "+pw);
		User u = new UserService().loginUser(id,pw);
		//user u= null;
		//User u = new User(1,"admin","kvOffyqGmDjNUIXm8X/IIQm8+YzWKkfLw3njjegLvAITojzubkoT3myq4K3Yo5AnLW8Ig8J0Mgsf9g28/G3XUA==","김철수");

		if(u != null) {
			//세션 정보 만들기
			HttpSession session = request.getSession(true);
			if(session.isNew() || session.getAttribute("user") == null) {
				session.setAttribute("user", u);
				session.setMaxInactiveInterval(60*30);
			}
			response.sendRedirect("/");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/login_fail.jsp");
			view.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
