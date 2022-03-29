package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.User;
import utility.MyConnection;

public class UserDaoImpl implements UserDaoInterface {

	Connection conn;

	public UserDaoImpl() {
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// implementation of user login
	@Override
	public boolean compareUserLogin(User user) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=? and password = ?");
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				boolean status = rs.getBoolean(10);
				user.setUserStatus(status);
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(4));
				user.setUserContact(rs.getString(5));
				user.setUserGender(rs.getString(6));
				user.setUserHobby(rs.getString(7));

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// implementation of of user service
	@Override
	public int userRegister(User user) {
		int id = 0;
		System.out.println("inside user dao impl");
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into user(name,email,password,contact,gender,hobby,dob,isAdmin)values(?,?,?,?,?,?,?,0)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserContact());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserHobby());
			pstmt.setString(7, user.getUserDOB());
			// pstmt.setBlob(8, user.getUserProfile());
			System.out.println("image inside user dao impl:" + user.getUserProfile());

			pstmt.executeUpdate();
			PreparedStatement stmt = conn.prepareStatement("select user_id from user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}

	@Override
	public List<User> displayUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("inside userdao impl");
		List<User> list = new ArrayList<User>();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where isAdmin=0");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("name"));
			user.setUserEmail(rs.getString("email"));
			user.setUserContact(rs.getString("contact"));
			user.setUserDOB(rs.getString("dob"));
			user.setUserGender(rs.getString("gender"));
			// user.setUserProfile(rs.getBlob("profile_img"));
			user.setUserHobby(rs.getString("hobby"));
			list.add(user);
		}

		return list;
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = conn.prepareStatement("delete from user where user_id=?");
		pstmt.setString(1, userId);
		pstmt.execute();

	}

	@Override
	public List<User> displayAdmin(User user) throws SQLException {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where isAdmin=1");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("name"));
			user.setUserEmail(rs.getString("email"));
			user.setUserContact(rs.getString("contact"));
			user.setUserDOB(rs.getString("dob"));
			user.setUserGender(rs.getString("gender"));
			// user.setUserProfile(rs.getBlob("profile_img"));
			user.setUserHobby(rs.getString("hobby"));
			list.add(user);
		}

		return list;
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET password =? WHERE email = ?");
		pstmt.setString(1, user.getUserPassword());
		pstmt.setString(2, user.getUserEmail());
		pstmt.executeUpdate();

	}

	@Override
	public void changeRole(User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET isAdmin = 1 WHERE user_id = ?");
		// pstmt.setBoolean(1, user.getUserStatus());
		pstmt.setInt(1, user.getUserId());
		pstmt.executeUpdate();

	}

	@Override
	public int addAddress(int userId, Address address) {
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into address(street,landmark,pincode,city,state,user_id) values(?,?,?,?,?,?)");

			pstmt.setString(1, address.getAddStreet());
			pstmt.setString(2, address.getAddLandmark());
			pstmt.setString(3, address.getAddCity());
			pstmt.setString(4, address.getAddState());
			pstmt.setString(5, address.getAddPincode());
			pstmt.setInt(6, userId);
			count = pstmt.executeUpdate();
			if (count != 0) {
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

}
