package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoResult.*;

public class LottoResultJudge {
    public static final LottoResultJudge getInstance = new LottoResultJudge();
    private int count[] = new int[5];

    public void judgeLotto(List<Integer> userLotto, List<Integer> lotto, int bonus) {
        int correctNum = correspondNumber(userLotto, lotto);
        boolean correspondBonus = correspondBonus(userLotto, bonus);

        if (correctNum == 3) {
            FIFTH.setCount(++count[4]);
        }
        if (correctNum == 4) {
            FOURTH.setCount(++count[3]);
        }
        if (correctNum == 5) {
            THIRD.setCount(++count[2]);
        }
        if (correctNum == 5 && correspondBonus) {
            SECOND.setCount(++count[1]);
        }
        if (correctNum == 6) {
            FIRST.setCount(++count[0]);
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
