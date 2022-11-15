package lotto.domain;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningResultCalculator {

    WinningStatusCalculator winningStatusCalculator = new WinningStatusCalculator();
    ReturnRatioCalculator returnRatioCalculator = new ReturnRatioCalculator();

    public Map<Rank, Integer> generateWinningStatus(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return winningStatusCalculator.createWinningStatus(lottos, winningNumbers);
    }

    public double generateReturnRatio(double expenses, Map<Rank, Integer> winningStatus) {
        return returnRatioCalculator.calculateReturnRatio(expenses, winningStatus);
    }

}
