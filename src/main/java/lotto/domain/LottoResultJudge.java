package lotto.domain;

import java.util.List;
import static lotto.domain.LottoResult.*;

public class LottoResultJudge {
    public static final LottoResultJudge getInstance = new LottoResultJudge();

    public void judgeLotto(List<Integer> userLotto, List<Integer> lotto, int bonus) {
        int correctNum = correspondNumber(userLotto, lotto);
        boolean correspondBonus = correspondBonus(userLotto, bonus);

        if (correctNum == 3) {
            FIFTH.updateCount();
        }
        if (correctNum == 4) {
            FOURTH.updateCount();
        }
        if (correctNum == 5) {
            THIRD.updateCount();
        }
        if (correctNum == 5 && correspondBonus) {
            SECOND.updateCount();
        }
        if (correctNum == 6) {
            FIRST.updateCount();
        }
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
