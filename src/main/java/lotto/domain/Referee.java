package lotto.domain;

import java.util.List;
import lotto.commons.LottoResult;

public class Referee {

    public String compare(List<Integer> myLotto, List<Integer> winLotto, int bonus) {
        Judgement judgement = new Judgement();
        int count = judgement.sameNumberCount(myLotto, winLotto);
        if (count == 6) {
            return LottoResult.FISRT_WIN.name();
        } else if (count == 5) {
            if (judgement.containBonusNumber(myLotto, bonus)) {
                return LottoResult.SECOND_WIN.name();
            }
            return LottoResult.THIRD_WIN.name();
        } else if (count == 4) {
            return LottoResult.FIRTH_WIN.name();
        } else if (count == 3) {
            return LottoResult.FIFTH_WIN.name();
        }
        return "";
    }
}
