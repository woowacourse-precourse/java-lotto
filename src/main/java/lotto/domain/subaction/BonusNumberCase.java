package lotto.domain.subaction;

import java.util.List;

public class BonusNumberCase {
    private static final int BONUS_CONDITIONS = 5;

    public int getBonusCount(List<List<Integer>> random, int bonus, List<Integer> winningNumbers,
            int bonusCaseCount, int correctNumberCheck) {

        CorrectNumberPlace correctNumberPlace = new CorrectNumberPlace();
        for (List<Integer> randomNumber : random) {
            correctNumberCheck = correctNumberPlace.getCorrectCount(winningNumbers,
                    correctNumberCheck, randomNumber);

            if (correctNumberCheck == BONUS_CONDITIONS && randomNumber.contains(bonus)) {
                bonusCaseCount++;
                break;
            }
            correctNumberCheck = 0;
        }
        return bonusCaseCount;
    }
}