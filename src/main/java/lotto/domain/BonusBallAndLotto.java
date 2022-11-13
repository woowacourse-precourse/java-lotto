package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.subaction.BonusNumberCase;

/**
 * 보너스 번호가 해당 되는 로또 찾기 구현
 */
public class BonusBallAndLotto {
    private final BonusNumberCase bonusNumberCase;

    public BonusBallAndLotto(BonusNumberCase bonusNumberCase) {
        this.bonusNumberCase = bonusNumberCase;
    }

    public List<Integer> getCorrectLocation(Lotto lottoAnswer, List<List<Integer>> random, List<Integer> resultNumber, int bonus) {
        List<Integer> WinningNumbers = lottoAnswer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (int sameNumber = 0; sameNumber < resultNumber.size(); sameNumber++) {
            int bonusCaseCount = 0;
            int correctNumberCheck = 0;

            if (resultNumber.get(sameNumber) == 5) {
                bonusCaseCount = bonusNumberCase.getBonusCount(random, bonus, WinningNumbers, bonusCaseCount, correctNumberCheck);
            }
            result.add(bonusCaseCount);
        }
        return result;
    }
}