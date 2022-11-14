package lotto.service;

import lotto.domain.User;

public class UserService {
    public User createUser(int money) {
        return new User(money);
    }
}
