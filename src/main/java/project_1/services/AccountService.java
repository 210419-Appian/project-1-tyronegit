package project_1.services;

import java.util.List;

import project_1.daos.AccountDAO;
import project_1.daos.AccountDAOImpl;
import project_1.daos.UserDAO;
import project_1.daos.UserDAOImpl;
import project_1.models.Account;
import project_1.models.User;

public class AccountService {

	private AccountDAO aDao = new AccountDAOImpl();
	private UserDAO uDao = new UserDAOImpl();

	public List<Account> Account() {

		return aDao.findAll();

	}

	public boolean addAccount(Account a) {
		if (a.setStatus(null)) {
			return aDao.addAccount(a);
		}
		
		User u = uDao.addUser(null)
		if(u.getName()==(null)) {
			return aDao.addAccount(a);
		}
		
		return aDao.addAccount(a);
	}

	public Account getOneAccount(int id) {
		return aDao.findById(id);
	}

	public boolean updateFullAccount(Account a) {
		return aDao.updateAccount(a);
	}

	public boolean updatePartialAccount(Account a) {
		if (a.getId() == 0) {
			return false;
		}

		Account aData = getOneAccount(a.getId());

		if (a.getSupName() == null) {
			a.setSupName(aData.getSupName());
		}
		if (a.getSupPower() == null) {
			a.setSupPower(aData.getSupPower());
		}
		if (a.getFirstName() == null) {
			a.setFirstName(aData.getFirstName());
		}
		if (a.getLastName() == null) {
			a.setLastName(aData.getLastName());
		}
		if (a.getPowerLevel() == 0) {
			a.setPowerLevel(aData.getPowerLevel());
		}
		if (a.getUserBases() == null) {
			a.setUserBases(aData.getUserBases());
		}

		return aDao.updateAccount(a);

	}

	public boolean killAccount(int id) {
		return aDao.deleteAccount(id);
	}
}
