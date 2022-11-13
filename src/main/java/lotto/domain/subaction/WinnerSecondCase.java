package lotto.domain.subaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerSecondCase {
    public List<Integer> CaseCount(List<Integer> sameNumberCount, List<Integer> bonusCase) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));
        int secondCaseCount = 0;

        for (int correctNumber : sameNumberCount) {
            if (correctNumber == 5) {
                for (int bonusIndexNumber : bonusCase) {
                    if (bonusIndexNumber >= 1) {
                        secondCaseCount++;
                    }
                }
            }
        }
        result.set(3, secondCaseCount);
        return result;
    }
}
