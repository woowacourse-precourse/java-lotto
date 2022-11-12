package lotto;

import java.util.List;

public class Matcher {
    private final int matchingWinningNumberCount;
    private final int matchingBonusNumberCount;

    public Matcher(List<Integer> consumerNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        matchingWinningNumberCount = compare(consumerNumbers, winningNumbers);
        matchingBonusNumberCount = checkBonusNumber(consumerNumbers, bonusNumber);
    }

    public int getMatchingWinningNumberCount() {
        return matchingWinningNumberCount;
    }

    public int getMatchingBonusNumberCount() {
        return matchingBonusNumberCount;
    }

    private int compare(List<Integer> consumerNumbers, List<Integer> winningNumbers) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (consumerNumbers.contains(winningNumbers.get(i))) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private int checkBonusNumber(List<Integer> consumerNumbers, Integer bonusNumber) {
        int matchingCount = 0;
        if (consumerNumbers.contains(bonusNumber)) {
            matchingCount++;
        }
        return matchingCount;
    }
}
