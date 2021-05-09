package project_1.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_1.models.Account;
import project_1.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAll() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account;";

			Statement statement = (Statement) conn.createStatement();

			ResultSet result = ((java.sql.Statement) statement).executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();
				account.setBalance(result.getInt("balance"));
				account.setStatus(result.getInt("status"));
				account.setType(result.getInt("type"));
				
				list.add(account);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Account findByName(int accountid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
