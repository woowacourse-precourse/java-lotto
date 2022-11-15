package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    public Lotto issue() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Lotto.START_RANGE, Lotto.END_RANGE, Lotto.NUMBER_COUNT));
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public double getYield(List<Rank> rankResult) {
        double winnings = getWinnings(rankResult);
        double payment = Lotto.PRICE * rankResult.size();
        double yield = winnings / payment * 100;
        return yield;
    }

    public int getWinnings(List<Rank> rankResult) {
        int winnings = 0;
        for (Rank rank : rankResult) {
            if (rank == null) {
                continue;
            }
            winnings += rank.getReward();
        }
        return winnings;
    }

    public Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
        for (Rank rank : Rank.RANK_ASC) {
            if (matchCount == Rank.SECOND.getMatchCount() && hasBonusNumber) {
                return Rank.SECOND;
            }
            if (matchCount == rank.getMatchCount()) {
                return rank;
            }
        }
        return null;
    }

    public int[] getRankCount(List<Rank> rankResult) {
        int[] rankCount = new int[Rank.MAX_RANK];
        for (Rank rank : rankResult) {
            if (rank == null) {
                continue;
            }
            rankCount[rank.getIndex()]++;
            ;
        }
        return rankCount;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        for (int myNum : lotto.getNumbers()) {
            if (myNum == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int myNum : lotto.getNumbers()) {
            if (winningNumbers.contains(myNum)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
