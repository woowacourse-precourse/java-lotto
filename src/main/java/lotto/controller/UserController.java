package lotto.controller;

import lotto.domain.user.User;
import lotto.service.UserService;
import lotto.view.Store;

public class UserController {
    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

    public Store buyLotto(User user){
        userService.buyLotto(user);
        return new Store(user);
    }
}
