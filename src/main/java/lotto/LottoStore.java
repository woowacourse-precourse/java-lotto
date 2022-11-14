package lotto;

import java.util.List;
import java.util.Map;

public class LottoStore {

    public void enter() {
        int money = InputConsole.purchaseMoney();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buy(money);
        OutputConsole.printLottoList(lottos);
        List<Integer> winningNumber = InputConsole.winningNumber();
        int bonusNumber = InputConsole.bonusNumber();
        Map<Rank, Integer> rankResult = lottoMachine.makeRankResult(lottos, winningNumber, bonusNumber);
        OutputConsole.printWinningList(rankResult);
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        double profitRate = profitRateCalculator.calculate(rankResult, money);
        OutputConsole.printProfitRate(profitRate);
    }
}
