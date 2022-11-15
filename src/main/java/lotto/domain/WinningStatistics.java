package lotto.domain;

import java.util.List;
import lotto.domain.subaction.WinnerRemainingCase;
import lotto.domain.subaction.WinnerSecondCase;

public class WinningStatistics {
    public List<Integer> countCheck(List<Integer> sameNumberCount, List<Integer> bonusNumber) {
        WinnerSecondCase winnerSecondCase = new WinnerSecondCase();
        List<Integer> secondCaseCount = winnerSecondCase.caseCount(sameNumberCount, bonusNumber);

        WinnerRemainingCase winnerRemainingCase = new WinnerRemainingCase();
        return winnerRemainingCase.caseCount(sameNumberCount, secondCaseCount);
    }
}
