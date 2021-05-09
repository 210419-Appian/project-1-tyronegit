package project_1_dao;

import java.util.List;

import project_1_models.Role;

public interface RoleDAO {
	
	List<Role> findAll();
	Role findByName(int roleId);
	boolean addRole(Role role);
}