package lotto.domain.subaction;

import java.util.List;

public class WinnerRemainingCase {

    public List<Integer> CaseCount(List<Integer> sameNumberCount, List<Integer> secondCaseCount) {
        int currentIndex = 0;
        for (int i = 3; i <= 6; i++) {
            int caseCount = 0;
            boolean secondCaseCheck = false;

            if (i == 6) {
                currentIndex++;
            }

            for (int correctNumber : sameNumberCount) {
                if (correctNumber == i && i < 5) {
                    caseCount++;
                }

                if (i == 5 && correctNumber == 5) {
                    caseCount++;
                    secondCaseCheck = true;
                }

                if (i == correctNumber && i == 6) {
                    caseCount++;
                }
            }

            if (i == 5 && secondCaseCheck == true) {
                if (secondCaseCount.get(3) >= 1) {
                    caseCount = secondCaseCount.get(3) - caseCount;
                }
            }

            secondCaseCount.set(currentIndex, caseCount);
            currentIndex++;


        }

        return secondCaseCount;
    }

}
