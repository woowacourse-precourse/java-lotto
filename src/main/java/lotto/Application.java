package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.purchase();
        lottoController.showPurchaseLotteries();
        lottoController.inputWinningNumber();
        lottoController.showWinningResult();
        lottoController.showWinningProfitPercentage();
    }
}
