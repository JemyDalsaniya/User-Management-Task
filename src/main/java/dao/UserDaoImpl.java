package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				boolean status = rs.getBoolean(9);
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
	public void userRegister(User user) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into user(name,email,password,contact,gender,hobby,isAdmin)values(?,?,?,?,?,?,0)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserContact());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserHobby());

			System.out.println("values inside user dao impl:" + user.getUserName());
			System.out.println("values inside user dao impl:" + user.getUserEmail());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
