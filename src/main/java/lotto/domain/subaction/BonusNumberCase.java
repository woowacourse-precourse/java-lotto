package lotto.domain.subaction;

import java.util.List;

public class BonusNumberCase {
    public int getBonusCount(List<List<Integer>> random, int bonus, List<Integer> WinningNumbers, int bonusCaseCount, int correctNumberCheck) {
        CorrectNumberPlace correctNumberPlace = new CorrectNumberPlace();

        for (List<Integer> randomNumber : random) {
            correctNumberCheck = correctNumberPlace.getCorrectCount(WinningNumbers, correctNumberCheck, randomNumber);

            if (correctNumberCheck == 5 && randomNumber.contains(bonus)) {
                bonusCaseCount++; // 있다면 카운트
                break;
            }
            correctNumberCheck = 0;
        }
        return bonusCaseCount;
    }
}
