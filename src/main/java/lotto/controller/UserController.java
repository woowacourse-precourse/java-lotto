package lotto.controller;

import lotto.domain.user.User;
import lotto.service.UserService;
import lotto.view.Store;

public class UserController {
    private final UserService userService;
    private final Store store;

    public UserController( UserService userService, Store store) {
        this.userService = userService;
        this.store = store;
    }

    public String buyLotto(User user){
        userService.buyLotto(user);
        return store.buyingLotto(user);
    }
}
