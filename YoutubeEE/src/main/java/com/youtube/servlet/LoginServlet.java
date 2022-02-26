package com.youtube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.youtube.dao.DAO;
import com.youtube.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    // Servlet: arbeitet mit Daten vom HTTP Request
    
    // HttpServletRequest: nimmt Daten vom HTTP-Request
    
    // HttpServletResponse: 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		User loggedUser = (User) session.getAttribute("loggedUser");
		
		if(loggedUser == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> users = DAO.users;
		boolean result = false;
		User loggedUser = null;
		
		for (User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				result = true;
				loggedUser = user;
			}
		}
		
		HttpSession session = request.getSession();     // neue Session erzeugen, falls noch keine vorhanden
		
		
		if(result) {
			request.setAttribute("user", username);
			session.setAttribute("loggedUser", loggedUser);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
		//doGet(request, response);
	}

}
