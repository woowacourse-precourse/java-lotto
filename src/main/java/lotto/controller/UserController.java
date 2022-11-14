package lotto.controller;

import lotto.service.StoreService;
import lotto.domain.user.User;
import lotto.service.UserService;
import lotto.view.Store;

public class UserController {
    private final StoreService storeService;
    private final UserService userService;
    private final Store store;

    public UserController(StoreService storeService, UserService userService, Store store) {
        this.storeService = storeService;
        this.userService = userService;
        this.store = store;
    }

    public String buyLotto(User user){
        userService.buyLotto(user);
        return store.buyingLotto(user);
    }
}
