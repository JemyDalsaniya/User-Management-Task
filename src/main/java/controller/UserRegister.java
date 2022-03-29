package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.User;
import service.UserServiceImpl;
import utility.EncryptionFile;
import utility.MyConnection;

/**
 * Servlet implementation class UserRegister
 */
@MultipartConfig(maxFileSize = 16177216)
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
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();

		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserContact(request.getParameter("contact"));
		user.setUserGender(request.getParameter("gender"));
		user.setUserDOB(request.getParameter("dob"));

		String hobbies = "";
		String[] hobby = request.getParameterValues("options");
		for (int i = 0; i < hobby.length; i++) {
			hobbies += hobby[i] + " ";
		}
		user.setUserHobby(hobbies);

		String encrypt_pwd = ee.encrypt(request.getParameter("password"));
		user.setUserPassword(encrypt_pwd);

		UserServiceImpl obj = new UserServiceImpl();
		int id = obj.userRegister(user);

		String[] street = request.getParameterValues("address[]");
		String[] landmark = request.getParameterValues("landmark[]");
		String[] pincode = request.getParameterValues("pincode[]");
		String[] city = request.getParameterValues("city[]");
		String[] state = request.getParameterValues("state[]");

		int count = 0;
		while (count < street.length) {
			Address addobj = new Address();
			addobj.setAddStreet(street[count]);
			addobj.setAddLandmark(landmark[count]);
			addobj.setAddCity(city[count]);
			addobj.setAddState(state[count]);
			addobj.setAddPincode(pincode[count]);

			obj.addAddress(id, addobj);
			count++;
		}

		RequestDispatcher req = request.getRequestDispatcher("/Userlogin.jsp");
		req.forward(request, response);

	}

}
