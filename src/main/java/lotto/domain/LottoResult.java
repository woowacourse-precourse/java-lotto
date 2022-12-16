package lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<Rank, Integer> result = new HashMap<>();

    public void getResult(WinningLotto winningLotto, Lottos purchaseLotto) {
        for (Iterator<Lotto> it = purchaseLotto.iterator(); it.hasNext(); ) {
            Lotto lotto = it.next();
            Rank rank = winningLotto.oneCompare(lotto);
            if (result.containsKey(rank)) {
                result.put(rank, result.get(rank) + 1);
                continue;
            }
            result.put(rank, 1);
        }
    }

    // OutputView에서만 꺼내기
    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    public double calculateProfitRate(int amount) {
        int totalPrize = calculateTotalPrize();
        return (totalPrize / (amount * 1.0)) * 100;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }
}
