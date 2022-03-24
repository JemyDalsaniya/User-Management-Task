package service;

import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserServiceDao {

	UserDaoImpl object = new UserDaoImpl();

	@Override
	public boolean compareUserLogin(User user) {
		boolean obj = object.compareUserLogin(user);
		return obj;
	}

}
