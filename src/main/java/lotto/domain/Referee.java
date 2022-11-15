package lotto.domain;

import java.util.List;
import lotto.commons.LottoResults;

public class Referee {

    public String compare(List<Integer> myLotto, List<Integer> winLotto, int bonus) {
        Judgement judgement = new Judgement();
        int count = judgement.sameNumberCount(myLotto, winLotto);
        if (count == 6) {
            return LottoResults.FIRST_WIN.name();
        } else if (count == 5) {
            if (judgement.containBonusNumber(myLotto, bonus)) {
                return LottoResults.SECOND_WIN.name();
            }
            return LottoResults.THIRD_WIN.name();
        } else if (count == 4) {
            return LottoResults.FIRTH_WIN.name();
        } else if (count == 3) {
            return LottoResults.FIFTH_WIN.name();
        }
        return "";
    }
}
