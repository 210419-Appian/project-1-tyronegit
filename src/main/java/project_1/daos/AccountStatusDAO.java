package project_1.daos;

import java.util.List;

import project_1.models.AccountStatus;

public interface AccountStatusDAO {
	
	List<AccountStatus> findAll();
	AccountStatus findByName(int statusid);
	boolean addAccountStatus(AccountStatus status);
}
