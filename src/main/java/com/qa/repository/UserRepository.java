package com.qa.repository;
 
import com.qa.model.User;

public interface UserRepository {
 
	public User createUser(User user);
	
	public User findUser(int id);
	
	
	public void deleteUser(int id);
}
