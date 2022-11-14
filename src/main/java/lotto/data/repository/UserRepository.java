package lotto.data.repository;

public class UserRepository {

    private static UserRepository instance;

    private UserRepository() {
        userCount = 0L;
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (UserRepository.class) {
            instance = new UserRepository();
        }
    }

    private Long userCount;

    public Long addNewUser() {
        return userCount++;
    }

}
