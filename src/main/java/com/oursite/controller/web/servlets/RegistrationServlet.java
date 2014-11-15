package main.java.com.oursite.controller.web.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.oursite.model.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String REGISTRATION_JSP="/jsp/registration.jsp";   
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	User user = new User();
	user.setEmail(request.getParameter("email"));
	user.setPassword(request.getParameter("password"));
	user.setPassword(request.getParameter("password"));
	
	//UserService service = new UserService();
	//service.insert(user);
	 
	request.setAttribute("email", request.getParameter("email"));
	request.setAttribute("password", request.getParameter("password"));
	request.setAttribute("password", request.getParameter("password"));
	RequestDispatcher x = request.getRequestDispatcher(
			"/jsp/job.jsp");
	x.forward(request, response);
	
	}

}
