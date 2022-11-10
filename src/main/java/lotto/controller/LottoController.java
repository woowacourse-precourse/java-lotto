package lotto.controller;

import lotto.validation.LottoMoneyValidation;
import lotto.validation.Validation;
import lotto.view.LottoBuyView;
import lotto.view.View;

public class LottoController {

    public void lottoProcedure() {
        int userMoney = userMoney();

    }

    private static int userMoney() {
        String userLottoBuyMoney = inputUserLottoBuyMoney();
        moneyValidation(userLottoBuyMoney);
        return Integer.parseInt(userLottoBuyMoney);
    }

    private static String inputUserLottoBuyMoney() {
        View lottoBuyView = new LottoBuyView();
        lottoBuyView.show();
        return lottoBuyView.getResponse();
    }

    private static void moneyValidation(String userLottoBuyMoney) {
        Validation lottoMoneyValidation = new LottoMoneyValidation();
        lottoMoneyValidation.isValidate(userLottoBuyMoney);
    }
}
