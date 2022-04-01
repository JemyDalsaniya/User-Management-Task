package dao;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import model.Address;
import model.User;

public interface UserDao {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean compareUserLogin(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int userRegister(User user, InputStream imgContent);

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> displayUser(User user) throws SQLException;

	/**
	 * 
	 * @param userId
	 * @throws SQLException
	 */
	public void deleteUser(String userId) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> displayAdmin(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void updatePassword(User user) throws SQLException;

	/**
	 * 
	 * @throws SQLException
	 */
	public void changeRole(String id) throws SQLException;

	/**
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public int addAddress(int userId, Address address);

}
