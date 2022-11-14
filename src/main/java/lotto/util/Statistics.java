package lotto.util;

import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final int ONE_HUNDRED_PERCENT = 100;
    private Map<Rank, Integer> totalResult = new HashMap<>();

    public void makeTotalResult(WinningNumbers winningNumbers, List<List<Integer>> lottoNumbers) {
        setTotalResult();
        for (List<Integer> lottoNumber : lottoNumbers) {
            Rank rank = compareLotto(winningNumbers, lottoNumber);
            addResult(rank);
        }
    }

    private void setTotalResult() {
        for (Rank rank : Rank.values()) {
            totalResult.put(rank, 0);
        }
    }

    private void addResult(Rank rank) {
        if (rank == null) {
            return;
        }
        int winCount = totalResult.get(rank);
        totalResult.put(rank, winCount + 1);
    }

    private Rank compareLotto(WinningNumbers winningNumbers, List<Integer> lotto) {
        boolean bonus = hasBonus(winningNumbers, lotto);
        int match = matchCount(winningNumbers, lotto);

        for (Rank rank : Rank.values()) {
            if (rank.hasSameRank(match, bonus)) {
                return rank;
            }
        }
        return null;
    }

    private boolean hasBonus(WinningNumbers winningNumbers, List<Integer> lotto) {
        return lotto.contains(winningNumbers.getBonusNumber());
    }

    private int matchCount(WinningNumbers winningNumbers, List<Integer> lotto) {
        lotto.retainAll(winningNumbers.getLottoNumber());
        return lotto.size();
    }

    public Map<Rank, Integer> getTotalResult() {
        return totalResult;
    }

    public double calculatorRevenue(int purchaseAmount) {
        return calculatorBenefit() / (double) purchaseAmount * ONE_HUNDRED_PERCENT;
    }

    private long calculatorBenefit() {
        long result = 0L;
        for (Rank rank : totalResult.keySet()) {
            result += (long) rank.getPrize() * totalResult.get(rank);
        }
        return result;
    }
}
