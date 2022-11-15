package lotto;

import lotto.controller.ResultController;
import lotto.controller.UserLottoController;

public class Application {
    private static UserLottoController userLottoController;
    private static ResultController resultController;

    public static void main(String[] args) {
        init();
        try {
            userLottoController.enterPurchaseAmount();
            userLottoController.printIssuedLotteries();
            resultController.enterWinningNumbers();
            resultController.enterBonusNumber();
            resultController.printLottoResult(userLottoController.getIssuedLotteries());
            userLottoController.calculateEarningRate();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void init() {
        userLottoController = UserLottoController.getInstance();
        resultController = ResultController.getInstance();
    }
}
