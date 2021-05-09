package project_1.dao;

import java.util.List;

import project_1.models.User;

public interface UserDAO {
	
	List<User> findAll();
	User findByName(int userid);
	boolean addUser(User user);
}
