package lotto.domain.user.presentation;

import lotto.domain.user.service.UserService;

public class UserController {

    private final UserService userService = new UserService();

    public int getInputMoney() {
        return userService.inputMoney();
    }
}
