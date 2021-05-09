package project_1.daos;

import java.util.List;

import project_1.models.Account;

public interface AccountDAO {
	
	List<Account> findAll();
	Account findByName(int accountid);
	boolean addAccount(Account account);
}
