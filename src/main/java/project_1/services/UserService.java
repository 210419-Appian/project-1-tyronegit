package project_1.services;

import java.util.List;

import project_1.daos.UserDAO;
import project_1.daos.UserDAOImpl;
import project_1.models.User;

public class UserService {
	
	private UserDAO uDao = new UserDAOImpl();
	
	public List<User> getAllUsers(){
		
		List<User> list = uDao.findAll();
		
		//any business logic that would need to take place can happen here. 
		
		return list;
		
	}
	
	public UserDAO findUserByName(String name) {
		return uDao.findByName(name);
	}
	
	/* public boolean createUser(User User) {
		if("Fury's secret bunker".equals(User.getName())) {
			return false;
		}else {
			return uDao.addUser(User);
		}
	} */


}
