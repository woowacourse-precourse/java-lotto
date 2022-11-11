package lotto.model;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {

    int checkMatches(Collection<Integer> lottoNumbers, List<Integer> winNumbers) {
        int correctNumber = lottoNumbers.size();
        lottoNumbers.removeAll(winNumbers);
        correctNumber -= lottoNumbers.size();
        return correctNumber;
    }

    boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
