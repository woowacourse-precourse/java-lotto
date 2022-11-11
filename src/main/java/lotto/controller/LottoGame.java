package lotto.controller;

import lotto.Data.User;
import lotto.service.UserLottoService;

public class LottoGame {
    UserLottoService userLottoService = new UserLottoService();
    public void run() {
        User user = userLottoService.InputMoney();
        countLotto(user);
    }
    public void countLotto(User user) {
        userLottoService.lottoCount(user);
    }
}