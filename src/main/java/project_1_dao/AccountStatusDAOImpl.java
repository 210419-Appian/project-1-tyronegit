package project_1_dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_1_models.AccountStatus;
import project_1_utils.ConnectionUtil;

public class AccountStatusDAOImpl implements AccountStatusDAO {

	@Override
	public List<AccountStatus> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accountstatus;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountStatus> list = new ArrayList<>();

			while (result.next()) {
				AccountStatus accountstatus = new AccountStatus();
				accountstatus.setStatusId(result.getInt("statusid"));
				accountstatus.setStatus(result.getString("status"));

				list.add(accountstatus);
			}

			return list;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountStatus findByName(int statusid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccountStatus(AccountStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

}
