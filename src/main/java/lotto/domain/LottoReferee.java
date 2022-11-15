package lotto.domain;

import lotto.constants.Constants;
import java.util.List;

public class LottoReferee {
    public static int sumSameNumbers(List<Integer> lottoNumbers, List<Integer> luckyNumbers) {
        int correctCount = 0;

        for (int i = 0; i < Constants.MAX_COUNT; i++){
            if (luckyNumbers.contains(lottoNumbers.get(i))) {
                correctCount += 1;
            }
        }
        return correctCount;
    }

    public static boolean includeBonusNumber(List<Integer> lottoNumbers, int bonusNumber){
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
