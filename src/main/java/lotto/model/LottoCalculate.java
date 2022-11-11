package lotto.model;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {
    enum LottoPrizeMoney {
        NONE(0), FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);
        final int prizeMoney;
        LottoPrizeMoney(int prizeMoney){
            this.prizeMoney = prizeMoney;
        }
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

    int calculateWinMoney(LottoPrizeMoney prizeNumber){
        return prizeNumber.prizeMoney;
    }
}
