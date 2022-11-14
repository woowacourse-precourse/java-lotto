package lotto.data.repository;

public class AccountRepository {

    private static AccountRepository instance;

    private AccountRepository(Long initUserId) {
        userCount = initUserId;
    }

    public static AccountRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (AccountRepository.class) {
            instance = new AccountRepository(0L);
        }
    }

    private Long userCount;

    public Long addNewUser() {
        return userCount++;
    }

}
