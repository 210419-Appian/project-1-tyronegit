package project_1_dao;

import java.util.List;

import project_1_models.AccountType;

public interface AccountTypeDAO {
	
	List<AccountType> findAll();
	AccountType findByName(int typeid);
	boolean addAccountType(AccountType type);
}