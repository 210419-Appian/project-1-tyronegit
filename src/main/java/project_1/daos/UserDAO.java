package project_1.daos;

import java.util.List;

import project_1.models.User;

public interface UserDAO {
	
	List<User> findAll();
	UserDAO findByName(Object object);
	boolean addUser(User user);
}
