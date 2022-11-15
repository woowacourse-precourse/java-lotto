package lotto.util;

import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final static int ONE_HUNDRED_PERCENT = 100;
    private final Map<Rank, Integer> winningStatistics = new HashMap<>();

    public void makeWinningStatistics(WinningNumbers winningNumbers, List<List<Integer>> lottoNumbers) {
        setWinningStatistics();
        for (List<Integer> lottoNumber : lottoNumbers) {
            Rank rank = compareLotto(winningNumbers, lottoNumber);
            matchedCount(rank);
        }
    }

    private void setWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    private void matchedCount(Rank rank) {
        if (rank == null) {
            return;
        }
        int winningCount = winningStatistics.get(rank);
        winningStatistics.put(rank, winningCount + 1);
    }

    private Rank compareLotto(WinningNumbers winningNumbers, List<Integer> lotto) {
        boolean bonus = hasBonus(winningNumbers, lotto);
        int match = matchNumber(winningNumbers, lotto);

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

    private int matchNumber(WinningNumbers winningNumbers, List<Integer> lotto) {
        lotto.retainAll(winningNumbers.getLottoNumber());
        return lotto.size();
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public double calculatorRevenueRatio(int purchaseAmount) {
        return calculatorBenefit() / (double) purchaseAmount * ONE_HUNDRED_PERCENT;
    }

    private long calculatorBenefit() {
        long benefit = 0L;
        for (Rank rank : winningStatistics.keySet()) {
            benefit += calculatorPrize(rank);
        }
        return benefit;
    }

    private long calculatorPrize(Rank rank) {
        return (long) rank.getPrize() * winningStatistics.get(rank);
    }
}
