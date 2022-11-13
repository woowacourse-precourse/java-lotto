package lotto.domain.subaction;

import java.util.List;

public class WinnerRemainingCase {
    private static final int SECOND_PRIZE_CONDITION = 5;
    private static final int SECOND_INDEX = 3;
    private static final int START_WINNING_RANKING = 3;
    private static final int LAST_WINNING_RANKING = 6;
    private static final int SECOND_CONDITION = 1;

    public List<Integer> CaseCount(List<Integer> sameNumberCount, List<Integer> secondCaseCount) {
        int currentIndex = 0;

        for (int rankIndex = START_WINNING_RANKING; rankIndex <= LAST_WINNING_RANKING; rankIndex++) {
            int caseCount = 0;
            currentIndex = getCurrentIndex(currentIndex, rankIndex);

            for (int correctNumber : sameNumberCount) {
                caseCount = getCaseCount(rankIndex, caseCount, correctNumber);
            }
            caseCount = getSecondCaseCount(secondCaseCount, rankIndex, caseCount);
            currentIndex = saveWinner(secondCaseCount, currentIndex, caseCount);
        }
        return secondCaseCount;
    }

    private int saveWinner(List<Integer> secondCaseCount, int currentIndex, int caseCount) {
        secondCaseCount.set(currentIndex, caseCount);
        currentIndex++;
        return currentIndex;
    }

    private int getCurrentIndex(int currentIndex, int rankIndex) {
        if (rankIndex == LAST_WINNING_RANKING) {
            currentIndex++;
        }
        return currentIndex;
    }

    private int getSecondCaseCount(List<Integer> secondCaseCount, int rankIndex, int caseCount) {
        if (rankIndex == SECOND_PRIZE_CONDITION) {
            if (secondCaseCount.get(SECOND_INDEX) >= SECOND_CONDITION) {
                caseCount = secondCaseCount.get(SECOND_INDEX) - caseCount;
            }
        }
        return caseCount;
    }

    private int getCaseCount(int rankIndex, int caseCount, int correctNumber) {
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
