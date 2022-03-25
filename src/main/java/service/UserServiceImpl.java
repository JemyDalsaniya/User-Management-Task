package service;

import dao.UserDaoImpl;
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
	public void userRegister(User user) {
		// TODO Auto-generated method stub
		object.userRegister(user);

	}

}
