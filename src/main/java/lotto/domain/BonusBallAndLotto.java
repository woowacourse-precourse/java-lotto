package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.subaction.BonusNumberCase;

public class BonusBallAndLotto {
    private static final int BONUS_CONDITIONS = 5;
    private final BonusNumberCase bonusNumberCase;

    public BonusBallAndLotto(BonusNumberCase bonusNumberCase) {
        this.bonusNumberCase = bonusNumberCase;
    }

    public List<Integer> getCorrectLocation(Lotto lottoAnswer, List<List<Integer>> random,
            List<Integer> resultNumber, int bonus) {

        List<Integer> winningNumbers = lottoAnswer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (Integer integer : resultNumber) {
            int bonusCaseCount = 0;
            int correctNumberCheck = 0;
            bonusCaseCount = getBonusCaseCount(random, bonus, winningNumbers, integer,
                    bonusCaseCount, correctNumberCheck);

            result.add(bonusCaseCount);
        }
        return result;
    }

    private int getBonusCaseCount(List<List<Integer>> random, int bonus,
            List<Integer> winningNumbers, Integer integer,
            int bonusCaseCount, int correctNumberCheck) {

        if (integer == BONUS_CONDITIONS) {
            bonusCaseCount = bonusNumberCase.getBonusCount(random, bonus, winningNumbers,
                    bonusCaseCount, correctNumberCheck);
        }
        return bonusCaseCount;
    }
}