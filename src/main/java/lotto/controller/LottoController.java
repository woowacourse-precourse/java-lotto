package lotto.controller;

import lotto.view.LottoBuyView;

public class LottoController {

    public void lottoProcedure() {
        String userLottoBuyMoney = inputUserLottoBuyMoney();

    }

    private static String inputUserLottoBuyMoney() {
        LottoBuyView lottoBuyView = new LottoBuyView();
        lottoBuyView.show();
        return lottoBuyView.getResponse();
    }
}
