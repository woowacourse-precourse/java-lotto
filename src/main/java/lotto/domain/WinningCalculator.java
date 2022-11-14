package lotto.domain;

import java.util.List;

public class WinningCalculator {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningCalculator(List<Integer> numbers, int number) {
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = number;
    }
}
