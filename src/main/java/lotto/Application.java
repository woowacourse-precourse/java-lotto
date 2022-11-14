package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.purchase();
        lottoController.showPurchaseLotteries();
        lottoController.inputWinningNumber();
        lottoController.inputBonusNumber();
    }
}
