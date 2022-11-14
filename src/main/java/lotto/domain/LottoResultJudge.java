package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoResult.*;

public class LottoResultJudge {
    public static final LottoResultJudge getInstance = new LottoResultJudge();

    public LottoResult judgeLotto(List<Integer> userLotto, List<Integer> lotto, int bonus) {
        int correctNum = correspondNumber(userLotto, lotto);
        boolean correspondBonus = correspondBonus(userLotto, bonus);

        if (correctNum == 6) {
            return FIRST;
        }
        if (correctNum == 5 && correspondBonus) {
            return SECOND;
        }
        if (correctNum == 5) {
            return THIRD;
        }
        if (correctNum == 4) {
            return FOURTH;
        }
        if (correctNum == 3) {
            return FIFTH;
        }
        return NOTHING;
    }

    private int correspondNumber(List<Integer> userLotto, List<Integer> lotto) {
        int correctNumber = 0;
        for(int userNum: userLotto) {
            if (lotto.contains(userNum)) {
                correctNumber++;
            }
        }
        return correctNumber;
    }

    private boolean correspondBonus(List<Integer> userLotto, int bonus) {
        return userLotto.contains(bonus);
    }
}
