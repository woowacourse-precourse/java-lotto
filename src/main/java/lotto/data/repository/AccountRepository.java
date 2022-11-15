package lotto.data.repository;

import java.util.HashMap;
import lotto.data.entity.Account;

public class AccountRepository {

    private static AccountRepository instance;

    public static AccountRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (AccountRepository.class) {
            instance = new AccountRepository();
        }
    }

    private final HashMap<Long, Account> accounts;

    private AccountRepository() {
        this.accounts = new HashMap<>();
    }

    public void save(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public int count() {
        return accounts.size();
    }
}
