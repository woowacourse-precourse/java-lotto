package lotto.domain.subaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Rank;

public class WinnerSecondCase {
    private static final int SECOND_PRIZE_CONDITION = 5;
    private static final int INITIAL_GENERATION = 5;
    private static final int BONUS_GUNBOAT_ONDITION = 1;

    public List<Integer> caseCount(List<Integer> sameNumberCount, List<Integer> bonusCase) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(INITIAL_GENERATION, 0));
        int secondCaseCount = 0;

        for (int correctNumber : sameNumberCount) {
            if (correctNumber == SECOND_PRIZE_CONDITION) {
                secondCaseCount = getSecondCaseCount(bonusCase, secondCaseCount);
            }
        }
        result.set(Rank.SECOND.ordinal(), secondCaseCount);
        return result;
    }

    private int getSecondCaseCount(List<Integer> bonusCase, int secondCaseCount) {
        for (int bonusIndexNumber : bonusCase) {
            if (bonusIndexNumber >= BONUS_GUNBOAT_ONDITION) {
                secondCaseCount++;
            }
        }
        return secondCaseCount;
    }
}