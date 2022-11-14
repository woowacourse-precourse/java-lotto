package lotto.data.repository;

public class AccountRepository {

    private static AccountRepository instance;

    private AccountRepository() {
        userCount = 0L;
    }

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

    private Long userCount;

    public Long addNewUser() {
        return userCount++;
    }

}
