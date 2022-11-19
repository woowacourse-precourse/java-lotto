package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.*;
import lotto.util.Statistics;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonus;

    public void run() {
        try {
            buy();
            inputWinningNumbers();
            printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void printStatistics() {
        Map<WinningTable, Integer> winningMap = getResult(lottos, winningNumbers, bonus);
        double profitRate = getProfitRate();
        StatisticsConsole statisticsConsole = new StatisticsConsole();
        statisticsConsole.print(winningMap, profitRate);
    }

    private void inputWinningNumbers() {
        WinningConsole winningConsole = new WinningConsole();
        winningNumbers = winningConsole.inputNumbers();
        bonus = winningConsole.inputBonus();

    }

    private void buy() {
        BuyConsole buy = new BuyConsole();
        buy.printInputMessage();
        int input = buy.inputPrice();
        buyLotto(input);
        buy.printLottos(lottos);
    }

    private void buyLotto(int price) {
        BuyLotto buyLotto = new BuyLotto(price);
        lottos = buyLotto.getLottos();
    }

    private Map<WinningTable, Integer> getResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        Winning winning = new Winning(winningNumbers, bonus);
        List<WinningTable> winningInfo = winning.getWinningInfo(lottos);
        return Statistics.winningTableListToMap(winningInfo);
    }

    private double getProfitRate() {
        Profit profit = new Profit();
        return profit.calProfitRate(winningPrices, 2);
    }
}
