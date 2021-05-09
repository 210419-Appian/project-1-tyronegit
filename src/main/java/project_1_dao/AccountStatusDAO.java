package project_1_dao;

import java.util.List;

import project_1_models.AccountStatus;

public interface AccountStatusDAO {
	
	List<AccountStatus> findAll();
	AccountStatus findByName(int statusid);
	boolean addAccountStatus(AccountStatus status);
}
