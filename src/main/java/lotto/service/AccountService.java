package lotto.service;

import lotto.data.repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService() {
        accountRepository = AccountRepository.getInstance();
    }

    /**
     * 유저별 구매 로또를 구별하기 위해 유저 아이디 번호를 사용했습니다.
     */
    public Long getNewId() {
        return accountRepository.addNewUser();
    }
}
