package project_1.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_1.models.Role;
import project_1.utils.ConnectionUtil;

public class RoleDAOImpl implements RoleDAO {
	
	@Override
	public List<Role> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM role;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Role> list = new ArrayList<>();

			while (result.next()) {
				Role role = new Role();
				role.setRoleId(result.getInt("roleid"));
				role.setRole(result.getString("roles"));
				list.add(role);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		return null;
	}

	@Override
	public Role findByName(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

}
