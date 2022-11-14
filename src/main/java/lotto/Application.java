package lotto;

import lotto.controller.ResultController;
import lotto.controller.UserLottoController;

public class Application {
    private static UserLottoController userLottoController;
    private static ResultController resultController;

    public static void main(String[] args) {
        init();
        userLottoController.enterPurchaseAmount();
        userLottoController.printIssuedLotteries();
        resultController.enterWinningNumbers();
        resultController.enterBonusNumber();
        resultController.printLottoResult(userLottoController.getIssuedLotteries());
    }

    private static void init() {
        userLottoController = UserLottoController.getInstance();
        resultController = ResultController.getInstance();
    }
}
