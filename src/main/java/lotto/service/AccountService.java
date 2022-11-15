package lotto.service;

import lotto.data.dao.AccountDao;

public class AccountService {

    private final AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public Long getNewId() {
        return accountDao.addNewAccount();
    }
}
