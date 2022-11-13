package lotto.service;

import lotto.domain.User;

public class UserService {
    public static User createUser(int money) {
        return new User(money);
    }
}
