package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningResultCalculatorImple implements WinningResultCalculator{

    WinningStatusCalculator winningStatusCalculator;
    ReturnRatioCalculator returnRatioCalculator;

    public WinningResultCalculatorImple(WinningStatusCalculator winningStatusCalculator
            , ReturnRatioCalculator returnRatioCalculator) {
        this.winningStatusCalculator = winningStatusCalculator;
        this.returnRatioCalculator = returnRatioCalculator;
    }

    @Override
    public Map<Rank, Integer> generateWinningStatus(List<Lotto> lottos, WinningNumbersImple winningNumbers) {
        return winningStatusCalculator.createWinningStatus(lottos, winningNumbers);
    }
    @Override
    public double generateReturnRatio(double expenses, Map<Rank, Integer> winningStatus) {
        return returnRatioCalculator.calculateReturnRatio(expenses, winningStatus);
    }

}
