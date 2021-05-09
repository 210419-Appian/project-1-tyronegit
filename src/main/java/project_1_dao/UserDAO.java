package project_1_dao;

import java.util.List;

import project_1_models.User;

public interface UserDAO {
	
	List<User> findAll();
	User findByName(int userid);
	boolean addUser(User user);
}
