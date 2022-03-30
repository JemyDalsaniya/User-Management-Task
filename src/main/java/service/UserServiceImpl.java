package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.UserDaoImpl;
import model.Address;
import model.User;

public class UserServiceImpl implements UserServiceDao {

	UserDaoImpl object = new UserDaoImpl();

	// method of userDaoImpl called..
	@Override
	public boolean compareUserLogin(User user) {
		boolean obj = object.compareUserLogin(user);
		return obj;
	}

	// method of userDaoImpl called..
	@Override
	public int userRegister(User user) {
		// TODO Auto-generated method stub
		int id = object.userRegister(user);
		return id;
	}

	@Override
	public void validateUserDetails(User user, Map<String, String> messages) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> displayUser(User user) throws SQLException {
		System.out.println("inside user service impl");

		// TODO Auto-generated method stub
		List<User> list = object.displayUser(user);
		return list;
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		object.deleteUser(userId);

	}

	@Override
	public List<User> displayAdmin(User user) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("method called");
		List<User> list = object.displayAdmin(user);
		return list;
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		// TODO Auto-generated method stub
		object.updatePassword(user);
	}

	@Override
	public void changeRole(String id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("user service change role method called");
		object.changeRole(id);
	}

	@Override
	public int addAddress(int userId, Address address) {
		int obj = object.addAddress(userId, address);
		return obj;
	}

//	public void validateUserDetails(User user, Map<String, String> messages) {
//		// TODO Auto-generated method stub
//
//		if (user.getUserName() == null || user.getUserName().trim().isEmpty()) {
//			messages.put("name", "Please enter Name!!");
//		} else if (!user.getUserName().matches("^[a-zA-Z\\s]*$")) {
//			messages.put("name", "Please enter alphabets only!!");
//		}
//
//		if (user.getUserEmail() == null || user.getUserEmail().trim().isEmpty()) {
//			messages.put("email", "Please enter Email!!");
//		} else if (!user.getUserEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
//			messages.put("email", "Please enter valid emailId!!");
//		}
//
//		if (user.getUserPassword() == null || user.getUserPassword().trim().isEmpty()) {
//			messages.put("password", "Please enter password!!");
//		} else if (!user.getUserPassword()
//				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")) {
//			messages.put("password", "Please enter valid password!!");
//		}
//
//		if (user.getUserContact() == null || user.getUserContact().trim().isEmpty()) {
//			messages.put("contact", "Please enter contact!!");
//		} else if (!user.getUserContact().matches("^[0-9]{10}$")) {
//			messages.put("contact", "Please enter valid Contact!!");
//		}
//
//	}

}
