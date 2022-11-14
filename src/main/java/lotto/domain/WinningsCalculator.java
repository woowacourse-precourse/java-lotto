package lotto.domain;

import java.util.*;

public class WinningsCalculator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningsCalculator(List<Integer> numbers, int number) {
        this.winningNumbers = new Lotto(numbers).getNumbers();
        this.bonusNumber = number;
    }

    public int countMatchingWinningNumbers(List<Integer> lotto) {
        int winningCount = 0;
        for (Integer number : winningNumbers) {
            if (isExistentNumber(lotto, number)) {
                System.out.println("당첨" + number);
                winningCount++;
            }
        }
        return winningCount;
    }

    public int countMatchingBonusNumbers(List<Integer> lotto) {
        if (isExistentNumber(lotto, bonusNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean isExistentNumber(List<Integer> numbers, int targetNumber) {
        return Collections.binarySearch(numbers, targetNumber) >= 0;
    }
}