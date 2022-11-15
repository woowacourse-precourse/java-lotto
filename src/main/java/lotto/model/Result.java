package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();
    private final float rateOfReturn;

    public Result(WinningLotto winningLotto, List<Lotto> lottos, int money) {
        for (Lotto lotto : lottos) {
            computeRank(winningLotto, lotto);
        }
        this.rateOfReturn = computeRateOfReturn(money, computeTotalReturn());
    }

    private void computeRank(WinningLotto winningLotto, Lotto lotto) {
        int common = countCommon(winningLotto.getWinningLotto(), lotto);
        boolean bonus = isBonus(winningLotto.getBonusNumber(), lotto);
        Rank rank = Rank.findRank(common, bonus);

        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    private int countCommon(Lotto winningLotto, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(integer -> winningLotto.getNumbers().contains(integer))
                .count();
    }

    private boolean isBonus(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private float computeRateOfReturn(int money, int totalReturn) {
        return (float) totalReturn / money * 100;
    }

    private int computeTotalReturn() {
        int totalReturn = 0;
        for (Rank rank : result.keySet()) {
            totalReturn += rank.prise() * result.get(rank);
        }

        return totalReturn;
    }

    public int getRankResult(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }
}
