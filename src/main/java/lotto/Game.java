package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.outputView;

public class Game {

    public void play() {
        Money money = new Money(InputView.inputMoney());
        Lotteries lotteries = LottoStore.buyLotto(money);

        outputView.printBuyLotto(money);
        outputView.printLotteries(lotteries);

        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningLottoNumber(),
                InputView.inputWinningBonusNumber());
        LottoResult lottoResult = lotteries.checkLottoResult(winningNumber);

        outputView.printLottoResult(lottoResult, lottoResult.calculateProfit(money));
    }
}
