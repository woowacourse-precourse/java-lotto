package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.outputView;

public class Game {
    public void play() {
        try {
            Money money = InputView.inputMoney();

            Lotteries lotteries = LottoStore.buyLotto(money);

            outputView.printBuyLotto(money);
            outputView.printLotteries(lotteries);

            WinningNumber winningNumber = InputView.inputWinningNumber();
            LottoResult lottoResult = lotteries.checkLottoResult(winningNumber);

            outputView.printLottoResult(lottoResult, lottoResult.calculateProfit(money));

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
