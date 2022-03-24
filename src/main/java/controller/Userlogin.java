package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserServiceImpl;

/**
 * Servlet implementation class Userlogin
 */
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		user.setUserEmail(request.getParameter("email"));
		user.setUserPassword(request.getParameter("password"));

		UserServiceImpl service = new UserServiceImpl();
		boolean isValid = service.compareUserLogin(user);
		System.out.println("isValid inside userlogin" + isValid);

		if (isValid) {
			if (user.getUserStatus()) {
				session.setAttribute("admin", user);
				response.sendRedirect("AdminHomePage.jsp");
			} else {

				session.setAttribute("user", user);
				response.sendRedirect("UserHomePage.jsp");
			}
		}
		/*
		 * else { messages.put("error", "Enter valid EmailId and Password!!");
		 * RequestDispatcher req = request.getRequestDispatcher("login.jsp");
		 * req.include(request, response); }
		 */
	}

}
