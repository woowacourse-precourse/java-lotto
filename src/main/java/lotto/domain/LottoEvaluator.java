package lotto.domain;

import java.util.Map;

public class LottoEvaluator {
    public int evaluate(Map<WinningResult, Integer> lottoResults) {
        int money = 0;
        for (WinningResult result : WinningResult.values()) {
            int winningTicket = lottoResults.getOrDefault(result, 0);
            money += winningTicket * result.getPrize();
        }
        return money;
    }
}
