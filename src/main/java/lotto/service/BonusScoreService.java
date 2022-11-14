package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Policy;

import java.util.List;

public class BonusScoreService {

    NumberMatcher numberMatcher = new NumberMatcher();

    public void bonusCase(List<Lotto> allLotto, List<Integer> winningNums, int bonusNum) {

        for (Lotto lotto : allLotto) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int num = numberMatcher.countSameNumber(lottoNumbers, winningNums);
            if (num == 5 && lottoNumbers.contains(bonusNum)) {

                Policy.increaseBonusCount();

                adjust();
            }
        }
    }

    private static void adjust() {
        Integer fiveMatchCount = Policy.count.get(2);
        Policy.count.add(2, fiveMatchCount - 1);

        Integer sixMatchCount = Policy.count.get(3);
        Policy.count.add(3, sixMatchCount - 1);
    }
}
