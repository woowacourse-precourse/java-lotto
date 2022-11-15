package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private List<Integer> winningPrices;

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
        Map<WinningTable, Integer> winningMap = getResult(lottos, winningLotto);
        double profitRate = getProfitRate();
        StatisticsConsole statisticsConsole = new StatisticsConsole();
        statisticsConsole.print(winningMap, profitRate);// UI 당첨통계 출력
    }

    private void runInputWinningNumbers() {
        WinningConsole winningConsole = new WinningConsole();
        List<Integer> winningNumber = winningConsole.inputNumbers(); // inputUI실행
        int bonus = winningConsole.inputBonus();
        setWinningLotto(winningNumber, bonus);
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

    private void setWinningLotto(List<Integer> winningNumbers, int bonus) {
        winningLotto = new WinningLotto(winningNumbers, bonus);
    }

    private Map<WinningTable, Integer> getResult(List<Lotto> lottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult(lottos, winningLotto);
        winningPrices = winningResult.getWinningPrices();
        return winningResult.getMap();
    }

    private double getProfitRate() {
        Profit profit = new Profit();
        return profit.calProfitRate(winningPrices, 2);
    }
}
