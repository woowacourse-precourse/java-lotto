package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;
import lotto.ui.UserInterface;

public class Account {
    private WinningCalculator winningCalculator;
    private Map<WinningResult, Integer> results = new LinkedHashMap();
    private int count;
    private int winningAmount;

    public Account(WinningCalculator winningCalculator) {
        this.winningCalculator = winningCalculator;
        this.results.put(WinningResult.RANK_NONE, 0);
        this.results.put(WinningResult.RANK_5, 0);
        this.results.put(WinningResult.RANK_4, 0);
        this.results.put(WinningResult.RANK_3, 0);
        this.results.put(WinningResult.RANK_2, 0);
        this.results.put(WinningResult.RANK_1, 0);
    }

    public void saveResult(List<Lotto> lottos) {
        this.count = lottos.size();
        lottos.stream()
                .forEach(lotto -> saveOneLotto(lotto));
        calculateWinningAmountByResults();
    }

    public void printResult() {
        UserInterface.printResult(results);
        UserInterface.printYield(getYield());
    }

    private void saveOneLotto(Lotto lotto) {
        WinningResult result = winningCalculator.getResultOfOneLotto(lotto);
        int previousCount = results.get(result);
        int nextCount = previousCount + 1;
        results.put(result, nextCount);
    }

    private void calculateWinningAmountByResults() {
        this.winningAmount = 0;
        for (WinningResult result: results.keySet()) {
            this.winningAmount += results.get(result) * result.getMoney();
        }
    }

    private String getYield() {
        double yieldRaw = winningAmount * 1000 / ((double) (count * 1000));
        double yieldRound = Math.round(yieldRaw);
        double yieldDivided10 = yieldRound / 10;
        String yield = String.format("%.1f", yieldDivided10);
        return yield;
    }
}
