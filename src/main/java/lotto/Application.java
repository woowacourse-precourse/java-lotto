package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.lottoPurchaseMoney;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController();

        lottoController.run();
    }
}
