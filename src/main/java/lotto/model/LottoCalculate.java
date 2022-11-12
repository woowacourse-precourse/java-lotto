package lotto.model;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {
    public enum LottoPrizeMoneyMatchCount {
        NONE(0, 0, 0), FIRST(1, 2000000000, 6), SECOND(2, 30000000, 5), THIRD(3, 1500000, 5),
        FOURTH(4, 50000, 4), FIFTH(5, 5000, 3);
        public final int prize;
        public final int prizeMoney;
        public final int matchCount;

        LottoPrizeMoneyMatchCount(int prize, int prizeMoney, int matchCount) {
            this.prize = prize;
            this.prizeMoney = prizeMoney;
            this.matchCount = matchCount;
        }
    }

    void totalCalculate(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        int matchCount = checkMatches(lotto.getNumbers(), winNumbers);
        boolean matchBonusNumber = checkBonusNumber(lotto.getNumbers(), bonusNumber);
        LottoPrizeMoneyMatchCount lottoPrizeMoneyMatchCount = calculatePrize(matchCount, matchBonusNumber);
        lotto.addPrize(lottoPrizeMoneyMatchCount.prize);
        lotto.addPrizeMoney(lottoPrizeMoneyMatchCount.prizeMoney);
    }

    int checkMatches(Collection<Integer> lottoNumbers, List<Integer> winNumbers) {
        int matchCount = 0;
        for (Integer winNumber : winNumbers) {
            if (lottoNumbers.contains(winNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    LottoPrizeMoneyMatchCount calculatePrize(int matchCount, boolean checkBonusNumber) {
        if (matchCount == 6) {
            return LottoPrizeMoneyMatchCount.FIRST;
        } else if (matchCount == 5 & checkBonusNumber) {
            return LottoPrizeMoneyMatchCount.SECOND;
        } else if (matchCount == 5) {
            return LottoPrizeMoneyMatchCount.THIRD;
        } else if (matchCount == 4) {
            return LottoPrizeMoneyMatchCount.FOURTH;
        } else if (matchCount == 3) {
            return LottoPrizeMoneyMatchCount.FIFTH;
        }
        return LottoPrizeMoneyMatchCount.NONE;
    }

    int calculateWinMoney(LottoPrizeMoneyMatchCount prizeNumber) {
        return prizeNumber.prizeMoney;
    }

    double calculatePercentageOfReturn(double money, double prizeMoneySum) {
        return Math.round(prizeMoneySum / money * 1000) / 10.0;
    }
}
