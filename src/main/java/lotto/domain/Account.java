package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;

public class Account {
    private WinningCalculator winningCalculator;
    private Map<WinningResult, Integer> results = new LinkedHashMap();
    private int count;
    private long winningAmount;

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

    public Map<WinningResult, Integer> getResults() {
        return this.results;
    }

    public String getYield() {
        double yieldRaw = winningAmount / ((double) (count * 1000));
        double yieldPercent = yieldRaw * 100;
        DecimalFormat decFormat = new DecimalFormat("###,##0.0");
        String yield = decFormat.format(yieldPercent);
        return yield;
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
}
