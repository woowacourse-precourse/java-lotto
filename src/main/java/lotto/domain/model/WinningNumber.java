package lotto.domain.model;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

}
