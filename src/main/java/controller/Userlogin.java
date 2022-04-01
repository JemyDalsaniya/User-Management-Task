package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;

public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Userlogin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service = new UserServiceImpl();
		System.out.println("inside user login");
		User user = new User();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
		}
		String decrypt_pwd = ee.encrypt(request.getParameter("password"));

		user.setUserEmail(request.getParameter("email"));
		user.setUserPassword(decrypt_pwd);

		boolean isValid = service.compareUserLogin(user);

		if (isValid) {
			if (user.getUserStatus()) {
				List<User> list1;
				try {
					list1 = service.displayAdmin(user);
					System.out.println(list1);
					session.setAttribute("adminList", list1);
					session.setAttribute("admin", user);
					response.sendRedirect("AdminHomePage.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				session.setAttribute("user", user);
				response.sendRedirect("UserHomePage.jsp");
			}
		}
	}
}
