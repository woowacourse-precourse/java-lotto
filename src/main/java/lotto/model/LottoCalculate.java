package lotto.model;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {

    int checkMatches(Collection<Integer> lottoNumbers, List<Integer> winNumbers) {
        int matchCount = lottoNumbers.size();
        lottoNumbers.removeAll(winNumbers);
        matchCount -= lottoNumbers.size();
        return matchCount;
    }

    boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    int calculatePrize(int matchCount, boolean checkBonusNumber) {
        if (matchCount == 6) {
            return 1;
        } else if (matchCount == 5 & checkBonusNumber) {
            return 2;
        } else if (matchCount == 5) {
            return 3;
        } else if (matchCount == 4) {
            return 4;
        } else if (matchCount == 3) {
            return 5;
        }
        return 0;
    }
}
