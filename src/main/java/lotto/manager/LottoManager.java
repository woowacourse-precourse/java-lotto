package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.*;
import lotto.util.Statistics;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int ROUND_POSITION = 2;

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
        int input = buyConsole.inputPrice();
        BuyLotto buyLotto = new BuyLotto(input);
        List<Lotto> lottos = buyLotto.getLottos();
        buyConsole.printLottos(lottos);

        return lottos;
    }

    private double calProfitRate(List<WinningTable> winningInfo) {
        List<Integer> winningPrices = Statistics.calWinningPricesFromWinningInfo(winningInfo);
        Profit profit = new Profit();
        return profit.calProfitRate(winningPrices, ROUND_POSITION);
    }
}
