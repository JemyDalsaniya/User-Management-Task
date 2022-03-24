package dao;

import model.User;

public interface UserDaoInterface {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean compareUserLogin(User user);

	public void userRegister(User user);

}
