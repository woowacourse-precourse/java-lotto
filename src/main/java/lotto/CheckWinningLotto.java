package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWinningLotto {
    private List<Integer> winningCount = Arrays.asList(0, 0, 0, 0, 0);  // 3개, 4개, 5개, 6개, 5+1개

    CheckWinningLotto() {
    }

    public List<Integer> winningIndexToCount(List<List<Integer>> comparedNumber, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> totalCount = checkWinningTotal(comparedNumber, winningNumber, bonusNumber);
        for (int index : totalCount) {
            int beforeCount = winningCount.get(index);
            this.winningCount.set(index, beforeCount + 1);
        }
        return this.winningCount;
    }

    private List<Integer> checkWinningTotal(List<List<Integer>> comparedNumber, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> totalCount = new ArrayList<>();
        for (List<Integer> integers : comparedNumber) {
            int correctCount = checkWinning(integers, winningNumber);
            if (correctCount >= 3) {
                totalCount.add(correctCount - 3);
            }

            if ((correctCount == 5) && (checkWinningBonus(integers, bonusNumber))) {
                totalCount.remove(totalCount.size() - 1);
                totalCount.add(4);
            }
        }
        return totalCount;
    }

    private int checkWinning(List<Integer> comparedNumber, List<Integer> winningNumber) {
        int correctCount = 0;

        for (int i = 0; i < winningNumber.size(); i++) {
            if (winningNumber.contains(comparedNumber.get(i))) {
                correctCount++;
            }
        }
        return correctCount;
    }

    private boolean checkWinningBonus(List<Integer> comparedNumber, int bonusNumber) {
        if (comparedNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
