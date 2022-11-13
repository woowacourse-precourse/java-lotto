package lotto.domain;

import java.util.List;

public class Draw {
    public static Enum<Correct> findCorrectType(List<Integer> lotto, List<String> winNum, int bonusNum) {
        int cnt = 0;
        int bonusCnt = 0;
        for (int i = 0; i < winNum.size(); i++) {
            if (lotto.contains(Integer.valueOf(winNum.get(i)))) {
                cnt++;
            }
            if (lotto.contains(bonusNum)) {
                bonusCnt++;
            }
        }
        if (cnt == 3) {
            return Correct.THREE;
        }
        if (cnt == 4) {
            return Correct.FOUR;
        }
        if (cnt == 5) {
            return Correct.FIVE;
        }
        if (cnt == 5 && bonusNum == 1) {
            return Correct.FIVE_BONUS;
        }
        if (cnt == 6) {
            return Correct.SIX;
        }
        return Correct.NOTHING;
    }
}
