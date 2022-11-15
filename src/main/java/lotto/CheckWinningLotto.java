package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWinningLotto {
    private final List<Integer> winningCount = Arrays.asList(0, 0, 0, 0, 0);  // (당첨 개수) 3개, 4개, 5개, 6개, 5+1개

    CheckWinningLotto() {
    }

    // Convert index to total count list of winning
    public List<Integer> totalWinningCount(List<List<Integer>> comparedNumber, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> totalCount = countWinningToIndex(comparedNumber, winningNumber, bonusNumber);
        for (int index : totalCount) {
            int beforeCount = winningCount.get(index);
            winningCount.set(index, beforeCount + 1);
        }
        return winningCount;
    }

    // Convert counted number of winning numbers for each lotto including bonus number to index
    private List<Integer> countWinningToIndex(List<List<Integer>> comparedNumber,
                                            List<Integer> winningNumber, int bonusNumber) {
        List<Integer> totalCount = new ArrayList<>();
        for (List<Integer> integers : comparedNumber) {
            int correctCount = countWinning(integers, winningNumber);
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

    // Count the number of winning numbers for each lotto except bonus number
    private int countWinning(List<Integer> comparedNumber, List<Integer> winningNumber) {
        int correctCount = 0;

        for (int i = 0; i < winningNumber.size(); i++) {
            if (winningNumber.contains(comparedNumber.get(i))) {
                correctCount++;
            }
        }
        return correctCount;
    }

    // Check if lotto number contains bonus number
    private boolean checkWinningBonus(List<Integer> comparedNumber, int bonusNumber) {
        if (comparedNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
