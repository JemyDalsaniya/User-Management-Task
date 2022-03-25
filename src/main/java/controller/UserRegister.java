package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserServiceImpl;
import utility.EncryptionFile;
import utility.MyConnection;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// create connection
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
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
		// doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		System.out.println("inside user register");
		User user = new User();

		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		/*
		 * user.setUserPassword(request.getParameter("password"));
		 */ user.setUserContact(request.getParameter("contact"));
		user.setUserGender(request.getParameter("gender"));
		String hobbies = "";
		String[] hobby = request.getParameterValues("options");
		for (String i : hobby) {
			hobbies += i + " ";
		}
		user.setUserHobby(hobbies);
		String encrypt_pwd = ee.encrypt(request.getParameter("password"));
		user.setUserPassword(encrypt_pwd);
		System.out.println("encrypted password" + encrypt_pwd);
		UserServiceImpl obj = new UserServiceImpl();
		obj.userRegister(user);
		RequestDispatcher req = request.getRequestDispatcher("/Userlogin.jsp");
		req.forward(request, response);

	}

}
