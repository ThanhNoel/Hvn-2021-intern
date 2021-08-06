package com.nashtech.intern.dao;

import java.util.List;

import com.nashtech.intern.model.User;

public interface IUserDAO {
	public List<User> getAllUser();
	public User getUserById(int userId);
	public void addUser(User user);
	public boolean modifyUser(User user);
}
