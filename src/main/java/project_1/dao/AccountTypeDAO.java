package project_1.dao;

import java.util.List;

import project_1.models.AccountType;

public interface AccountTypeDAO {
	
	List<AccountType> findAll();
	AccountType findByName(int typeid);
	boolean addAccountType(AccountType type);
}