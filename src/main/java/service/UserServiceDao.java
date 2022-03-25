package service;

import model.User;

public interface UserServiceDao {

	public boolean compareUserLogin(User user);

	public void userRegister(User user);
}
