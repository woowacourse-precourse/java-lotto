package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.BuyingLotto;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningTable;
import lotto.util.Statistics;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private int original;
    public void run() {
        try {
            List<Lotto> lottos = buy();
            Winning winning = inputWinningNumbers();
            printStatistics(winning.getWinningInfo(lottos));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void printStatistics(List<WinningTable> winningInfo) {
        Map<WinningTable, Integer> winningMap = Statistics.winningTableListToMap(winningInfo);
        StatisticsConsole statisticsConsole = new StatisticsConsole();
        statisticsConsole.print(winningMap, calProfitRate(winningInfo));
    }

    private Winning inputWinningNumbers() {
        WinningConsole winningConsole = new WinningConsole();
        List<Integer> winningNumbers = winningConsole.inputNumbers();
        int bonus = winningConsole.inputBonus();
        return new Winning(winningNumbers, bonus);
    }

    private List<Lotto> buy() {
        BuyConsole buyConsole = new BuyConsole();
        buyConsole.printInputMessage();
        original = buyConsole.inputPrice();
        BuyingLotto buyingLotto = new BuyingLotto(original);
        List<Lotto> lottos = buyingLotto.getLottos();
        buyConsole.printLottos(lottos);

        return lottos;
    }

    private double calProfitRate(List<WinningTable> winningInfo) {
        List<Integer> winningPrices = Statistics.calWinningPricesFromWinningInfo(winningInfo);
        int profit = Statistics.sum(winningPrices);
        return Statistics.calProfitRate(original, profit);
    }

}
