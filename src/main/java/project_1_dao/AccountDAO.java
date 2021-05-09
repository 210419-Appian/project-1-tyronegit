package project_1_dao;

import java.util.List;

import project_1_models.Account;

public interface AccountDAO {
	
	List<Account> findAll();
	Account findByName(int accountid);
	boolean addAccount(Account account);
}
