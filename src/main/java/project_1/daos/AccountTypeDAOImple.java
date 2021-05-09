package project_1.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_1.models.AccountType;
import project_1.utils.ConnectionUtil;

public class AccountTypeDAOImple implements AccountTypeDAO {

	@Override
	public List<AccountType> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounttype;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountType> list = new ArrayList<>();

			while (result.next()) {
				AccountType accounttype = new AccountType();
				accounttype.setTypeId(result.getInt("typeid"));
				accounttype.setType(result.getString("type"));

				list.add(accounttype);
			}

			return list;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccountType findByName(int typeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccountType(AccountType type) {
		// TODO Auto-generated method stub
		return false;
	}

}
