package lotto.domain;

import java.util.List;

public class Draw {

    public static Enum<CorrectNum> findCorrectType(List<Integer> lotto, List<String> winNum,
        int bonusNum) {
        int cnt = 0;
        int bonusCnt = 0;
        for (int i = 0; i < winNum.size(); i++) {
            if (lotto.contains(Integer.valueOf(winNum.get(i)))) {
                cnt++;
            }
        }
        if (lotto.contains(bonusNum)) {
            bonusCnt++;
        }
        if (cnt == 3) {
            return CorrectNum.THREE;
        }
        if (cnt == 4) {
            return CorrectNum.FOUR;
        }
        if (cnt == 5 && bonusCnt == 1) {
            return CorrectNum.FIVE_BONUS;
        }
        if (cnt == 5) {
            return CorrectNum.FIVE;
        }
        if (cnt == 6) {
            return CorrectNum.SIX;
        }
        return CorrectNum.NOTHING;
    }
}
