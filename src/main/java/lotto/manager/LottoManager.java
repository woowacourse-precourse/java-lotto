package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private List<Lotto> lottos;
    private List<Integer> winningPrices;
    private List<Integer> winningNumbers;
    private int bonus;

    public void run() {
        try {
            runBuy();
            runInputWinningNumbers();
            runPrintStatistics();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void runPrintStatistics() {
        Map<WinningTable, Integer> winningMap = getResult(lottos, winningNumbers, bonus);
        double profitRate = getProfitRate();
        StatisticsConsole statisticsConsole = new StatisticsConsole();
        statisticsConsole.print(winningMap, profitRate);// UI 당첨통계 출력
    }

    private void runInputWinningNumbers() {
        WinningConsole winningConsole = new WinningConsole();
        winningNumbers = winningConsole.inputNumbers(); // inputUI실행
        bonus = winningConsole.inputBonus();

    }

    private void runBuy() {
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
        WinningResult winningResult = new WinningResult(winningNumbers, bonus);
        winningPrices = winningResult.getWinningPrices(lottos);
        return winningResult.getMap(lottos);
    }

    private double getProfitRate() {
        Profit profit = new Profit();
        return profit.calProfitRate(winningPrices, 2);
    }
}
