package lotto;

import lotto.controller.UserController;
import lotto.view.GameProgressView;
import lotto.view.WinningStatsView;

public class LottoApplication {
    private static UserController userController = new UserController();

    public static void run() {
        userController.savePurchaseAmount();
        userController.showPurchaseInfo();
        userController.randomLotteryIssuanceAndShow();
        userController.enterWinningNumbersAndSave();
        userController.enterBonusNumberAndSave();
        userController.showWinningStatisticsAndSave();
        userController.showRateOfReturnAndSave();
    }
}
