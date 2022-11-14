package lotto.service;

import lotto.domain.user.User;

public class UserService {
    private final StoreService storeService;

    public UserService(StoreService storeService) {
        this.storeService = storeService;
    }

    public void buyLotto(User user){
        int numberOfLotto = storeService.numberOfSoldLotto(user.getMoney());
        for (int i = 0; i < numberOfLotto; i++){
            user.buyLotto(storeService.sellLotto());
        }
    }
}
