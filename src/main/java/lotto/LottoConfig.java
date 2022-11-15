package lotto;

import lotto.controller.RankController;
import lotto.controller.UserController;
import lotto.service.RankService;
import lotto.service.StoreService;
import lotto.service.UserService;
import lotto.view.RankingView;
import lotto.view.Store;

public class LottoConfig {
    public StoreService storeService() {
        return new StoreService();
    }
    public UserService userService(){
        return new UserService(storeService());
    }

    public RankService rankService() {
        return new RankService();
    }
    public UserController userController() {
        return new UserController(userService());
    }
    public RankController rankController(){
        return new RankController(rankService());
    }
}
