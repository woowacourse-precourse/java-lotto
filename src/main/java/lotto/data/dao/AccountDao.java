package lotto.data.dao;

import lotto.data.repository.AccountRepository;

public class AccountDao {

    private final AccountRepository accountRepository;

    public AccountDao() {
        accountRepository = AccountRepository.getInstance();
    }

    public Long addNewUser() {
        return accountRepository.addNewUser();
    }
}
