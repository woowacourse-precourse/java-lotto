package lotto.manager;

import lotto.console.BuyConsole;
import lotto.console.StatisticsConsole;
import lotto.console.WinningConsole;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class LottoManager {
    List<Lotto> lottos;
    WinningLotto winningLotto;
    List<Integer> winningPrices;

    public void run() {
        runBuy();
        runInputWinningNumbers();
        runPrintStatistics();
    }

    public void runPrintStatistics() {
        Map<WinningTable, Integer> winningMap = getResult(lottos, winningLotto);
        double profitRate = getProfitRate();
        StatisticsConsole statisticsConsole = new StatisticsConsole();
        statisticsConsole.print(winningMap, profitRate);// UI 당첨통계 출력
    }
    public void runInputWinningNumbers() {
        WinningConsole winningConsole = new WinningConsole();
        List<Integer> winningNumber = winningConsole.inputNumbers(); // inputUI실행
        int bonus = winningConsole.inputBonus();
        setWinningLotto(winningNumber, bonus);
    }
    public void runBuy() {
        BuyConsole buy = new BuyConsole();
        buy.printInputMessage();
        int input =  buy.inputPrice();
        buyLotto(input);
        buy.printLottos(lottos);
    }

    public void buyLotto(int price) {
        BuyLotto buyLotto = new BuyLotto(price);
        lottos = buyLotto.getLottos();
    }

    public void setWinningLotto(List<Integer> winningNumbers, int bonus) {
        winningLotto = new WinningLotto(winningNumbers, bonus);
    }

    public Map<WinningTable, Integer> getResult(List<Lotto> lottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult(lottos, winningLotto);
        winningPrices = winningResult.getWinningPrices();
        return winningResult.getMap();
    }

    public double getProfitRate() {
        Profit profit = new Profit();
        return profit.calProfitRate(winningPrices, 2);
    }
}
