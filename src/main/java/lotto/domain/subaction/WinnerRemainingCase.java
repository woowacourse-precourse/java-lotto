package lotto.domain.subaction;

import java.util.List;
import lotto.constants.Rank;

public class WinnerRemainingCase {
    private static final int SECOND_PRIZE_CONDITION = 5;
    private static final int START_WINNING_RANKING = 3;
    private static final int LAST_WINNING_RANKING = 6;
    private static final int SECOND_CONDITION = 1;

    public List<Integer> caseCount(List<Integer> sameNumberCount, List<Integer> secondCaseCount) {
        int currentIndex = 0;

        for (int rankIndex = START_WINNING_RANKING; rankIndex <= LAST_WINNING_RANKING; rankIndex++) {

            int caseCount = 0;
            currentIndex = getCurrentIndex(currentIndex, rankIndex);
            caseCount = getCaseCount(sameNumberCount, rankIndex, caseCount);
            caseCount = getSecondCaseCount(secondCaseCount, rankIndex, caseCount);

            secondCaseCount.set(currentIndex, caseCount);
            currentIndex++;
        }
        return secondCaseCount;
    }

    private int getCurrentIndex(int currentIndex, int rankIndex) {
        if (rankIndex == LAST_WINNING_RANKING) {
            currentIndex++;
        }
        return currentIndex;
    }

    private int getSecondCaseCount(List<Integer> secondCaseCount, int rankIndex, int caseCount) {
        if (rankIndex == SECOND_PRIZE_CONDITION
                && secondCaseCount.get(Rank.SECOND.ordinal()) >= SECOND_CONDITION) {

            caseCount = secondCaseCount.get(Rank.SECOND.ordinal()) - caseCount;
        }
        return caseCount;
    }

    private int getCaseCount(List<Integer> sameNumberCount, int rankIndex, int caseCount) {
        for (int correctNumber : sameNumberCount) {
            caseCount = winningCount(rankIndex, caseCount, correctNumber);
        }
        return caseCount;
    }

    private int winningCount(int rankIndex, int caseCount, int correctNumber) {
        if (correctNumber == rankIndex && rankIndex < SECOND_PRIZE_CONDITION) {
            caseCount++;
        }

        if (rankIndex == correctNumber && rankIndex == LAST_WINNING_RANKING) {
            caseCount++;
        }

        if (rankIndex == SECOND_PRIZE_CONDITION && correctNumber == SECOND_PRIZE_CONDITION) {
            caseCount++;
        }
        return caseCount;
    }
}