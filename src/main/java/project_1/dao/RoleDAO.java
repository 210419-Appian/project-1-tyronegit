package project_1.dao;

import java.util.List;

import project_1.models.Role;

public interface RoleDAO {
	
	List<Role> findAll();
	Role findByName(int roleId);
	boolean addRole(Role role);
}