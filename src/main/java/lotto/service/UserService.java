package lotto.service;

import lotto.domain.User;

public class UserService {
    public User createUser(int money) throws IllegalArgumentException {
        return new User(money);
    }
}
