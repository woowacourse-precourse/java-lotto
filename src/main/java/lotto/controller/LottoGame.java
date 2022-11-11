package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.InputMoney;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();
    public void run() {
        UserMoney userMoney = inputMoney.InputMoney();
        countLottoPaper(userMoney);
    }
    public void countLottoPaper(UserMoney userMoney) {
        inputMoney.lottoCount(userMoney);
    }
}