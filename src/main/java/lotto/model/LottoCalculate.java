package lotto.model;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {
    enum LottoPrizeMoney {
        NONE(0, 0), FIRST(1, 2000000000), SECOND(2, 30000000), THIRD(3, 1500000), FOURTH(4, 50000), FIFTH(5, 5000);
        final int prize;
        final int prizeMoney;

        LottoPrizeMoney(int prize, int prizeMoney) {
            this.prize = prize;
            this.prizeMoney = prizeMoney;
        }
    }

    void totalCalculate(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        int matchCount = checkMatches(lotto.getNumbers(), winNumbers);
        boolean matchBonusNumber = checkBonusNumber(lotto.getNumbers(), bonusNumber);
        LottoPrizeMoney lottoPrizeMoney = calculatePrize(matchCount, matchBonusNumber);
        lotto.addPrize(lottoPrizeMoney.prize);
        lotto.addPrizeMoney(lottoPrizeMoney.prizeMoney);
    }

    int checkMatches(Collection<Integer> lottoNumbers, List<Integer> winNumbers) {
        int matchCount = lottoNumbers.size();
        lottoNumbers.removeAll(winNumbers);
        matchCount -= lottoNumbers.size();
        return matchCount;
    }

    boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    LottoPrizeMoney calculatePrize(int matchCount, boolean checkBonusNumber) {
        if (matchCount == 6) {
            return LottoPrizeMoney.FIRST;
        } else if (matchCount == 5 & checkBonusNumber) {
            return LottoPrizeMoney.SECOND;
        } else if (matchCount == 5) {
            return LottoPrizeMoney.THIRD;
        } else if (matchCount == 4) {
            return LottoPrizeMoney.FOURTH;
        } else if (matchCount == 3) {
            return LottoPrizeMoney.FIFTH;
        }
        return LottoPrizeMoney.NONE;
    }

    int calculateWinMoney(LottoPrizeMoney prizeNumber) {
        return prizeNumber.prizeMoney;
    }

    double calculatePercentageOfReturn(double money, double prizeMoneySum) {
        return Math.round(prizeMoneySum / money * 1000) / 10.0;
    }
}
