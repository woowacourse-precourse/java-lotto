package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Score;

import java.util.List;

public class BonusScoreService {

    public void bonusCase(List<Lotto> allLotto, List<Integer> winningNums, int bonusNum) {

        for (Lotto lotto : allLotto) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int num = NumberMatcher.countSameNumber(lottoNumbers, winningNums);
            if (num == 5 && lottoNumbers.contains(bonusNum)) {

                Score.increaseBonusCount();

                adjust();
            }
        }
    }

    private static void adjust() {
        Integer fiveMatchCount = Score.count.get(2);
        Score.count.add(2, fiveMatchCount - 1);

        Integer sixMatchCount = Score.count.get(3);
        Score.count.add(3, sixMatchCount - 1);
    }
}
