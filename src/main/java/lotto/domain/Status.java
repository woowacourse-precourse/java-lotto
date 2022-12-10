package lotto.domain;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {
    private final Map<Rank, Integer> countMatch = new HashMap<>();
    private double totalPrize = 0;

    public Status() {
        countMatch.put(Rank.FIFTH, 0);
        countMatch.put(Rank.FOURTH, 0);
        countMatch.put(Rank.THIRD, 0);
        countMatch.put(Rank.SECOND, 0);
        countMatch.put(Rank.FIRST, 0);
    }

    public Result makeResult() {
        return new Result(countMatch, totalPrize);
    }

    public void findMatch(List<Lotto> lottoList, WinningNumber winningNumber) {
        for (Lotto lotto : lottoList) {
            makeCount(Rank.findRank(lotto.findMatchNumber(winningNumber),
                    lotto.hasBonusNumber(winningNumber.getBonusNumber())));
        }
    }

    private void makeCount(Rank rank) {
        if (countMatch.containsKey(rank)) {
            countMatch.put(rank, countMatch.get(rank) + 1);
            return;
        }

        countMatch.put(rank, 1);
    }

    public void calculateRateOfReturn(int purchaseAmt) {
        for (Rank rank : countMatch.keySet()) {
            totalPrize += rank.getPrize() * countMatch.get(rank);
        }

        totalPrize = totalPrize / (double) purchaseAmt * 100;
    }
}
