package project_1.daos;

import java.util.List;

import project_1.models.AccountType;

public interface AccountTypeDAO {
	
	List<AccountType> findAll();
	AccountType findByName(int typeid);
	boolean addAccountType(AccountType type);
}