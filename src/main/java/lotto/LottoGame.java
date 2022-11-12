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
        Money money = new Money(InputView.getMoneyInput());
        List<Lotto> lottos = new Shop(money).buyLotto();
        WinningNumbers winningNumbers = new WinningNumbers(InputView.getWinningInput(), InputView.getBonusInput());

        Calculator rankCountMap = new Calculator(winningNumbers, lottos);
        PrizeMoney prizeMoney = new PrizeMoney(money, rankCountMap.getTotalPrice());

        OutputView.printWinningInfo(rankCountMap);
        OutputView.printProfit(prizeMoney.getPrize());
    }

}
