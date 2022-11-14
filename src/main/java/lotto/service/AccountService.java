package lotto.service;

import lotto.data.dao.AccountDao;

public class AccountService {

    private final AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    /**
     * 유저별 구매 로또를 구별하기 위해 유저 아이디 번호를 사용했습니다.
     */
    public Long getNewId() {
        return accountDao.addNewUser();
    }
}
