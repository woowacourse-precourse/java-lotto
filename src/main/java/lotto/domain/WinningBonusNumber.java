package lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningBonusNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningBonusNumber(List<Integer> winningNumbers, int bonusNumber) {

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicated(List<Integer> winningNumbers) {
        Set<Integer> checkDuplicated = new HashSet<>();

        for (int number : winningNumbers) {
            checkDuplicated.add(number);
        }

        if (checkDuplicated.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> winningNumbers) {
        int min = winningNumbers.stream().sorted().findFirst().get();
        int max = winningNumbers.stream().sorted(Comparator.reverseOrder()).findFirst().get();

        if(min < Number.LOTTO_NUMBER_MIN || max > Number.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
