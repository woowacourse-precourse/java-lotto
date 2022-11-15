package lotto;

import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.PrizeMoney;
import lotto.domain.Shop;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void run() {
        try {
            Money money = new Money(InputView.getMoneyInput());
            List<Lotto> lottos = new Shop(money).buyLotto();
            WinningNumbers winningNumbers = new WinningNumbers(InputView.getWinningInput(), InputView.getBonusInput());

            Calculator rankCountMatch = new Calculator(winningNumbers, lottos);
            PrizeMoney prizeMoney = new PrizeMoney(money, rankCountMatch.getTotalPrice());

            OutputView.printWinningInfo(rankCountMatch);
            OutputView.printProfit(prizeMoney.getProfit());
        } catch (IllegalArgumentException error) {
            OutputView.printString(error.getMessage());
        }

    }
}
