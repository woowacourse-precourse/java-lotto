package lotto;

import java.util.List;
import java.util.Map;

public class LottoStore {

    public void enter() {
        try {
            int money = InputConsole.purchaseMoney();
            LottoMachine lottoMachine = new LottoMachine();
            List<Lotto> lottos = lottoMachine.buy(money);
            OutputConsole.printLottoList(lottos);
            List<Integer> winningNumber = InputConsole.winningNumber();
            int bonusNumber = InputConsole.bonusNumber(winningNumber);
            Map<Rank, Integer> rankResult = lottoMachine.makeRankResult(lottos, winningNumber, bonusNumber);
            OutputConsole.printWinningList(rankResult);
            ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
            double profitRate = profitRateCalculator.calculate(rankResult, money);
            OutputConsole.printProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
