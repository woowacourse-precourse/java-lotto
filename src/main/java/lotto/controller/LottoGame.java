package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.UserLottoService;

public class LottoGame {
    UserLottoService userLottoService = new UserLottoService();
    public void run() {
        UserMoney userMoney = userLottoService.InputMoney();
        countLottoPaper(userMoney);
    }
    public void countLottoPaper(UserMoney userMoney) {
        userLottoService.lottoCount(userMoney);
    }
}