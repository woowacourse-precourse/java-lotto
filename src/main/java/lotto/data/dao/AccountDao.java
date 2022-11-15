package lotto.data.dao;

import lotto.data.entity.Account;
import lotto.data.repository.AccountRepository;

public class AccountDao {

    private final AccountRepository accountRepository;

    public AccountDao() {
        accountRepository = AccountRepository.getInstance();
    }

    public Long addNewAccount() {
        Long newId = (long) accountRepository.count() + 1;
        accountRepository.save(new Account(newId));
        return newId;
    }
}
