package lotto.logic;

import lotto.domain.User;

public class UserLogic {
    private static UserLogic userLogic = new UserLogic();

    private UserLogic() {
    }

    public static UserLogic getInstance() {
        return userLogic;
    }
    public User makeUser(Integer money) {
        return new User(money);
    }
}
