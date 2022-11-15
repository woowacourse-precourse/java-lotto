package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printPayMessage();
        int money = InputView.inputMoney();
        LottoGame lottoGame = new LottoGame(money);
        lottoGame.start();
    }
}
