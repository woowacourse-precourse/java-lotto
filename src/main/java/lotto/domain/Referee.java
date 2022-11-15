package lotto.domain;

import java.util.List;

public class Referee {

    public String compare(List<Integer> myLotto, List<Integer> winLotto, int bonus) {
        Judgement judgement = new Judgement();
        int count = judgement.sameNumberCount(myLotto, winLotto);
        if (count == 6) {
            return "FIRST_WIN";
        } else if (count == 5) {
            if (judgement.containBonusNumber(myLotto, bonus)) {
                return "SECOND_WIN";
            }
            return "THIRD_WIN";
        } else if (count == 4) {
            return "FIRTH_WIN";
        } else if (count == 3) {
            return "FIFTH_WIN";
        }
        return "";
    }
}
