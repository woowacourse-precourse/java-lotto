package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        winningNumbers = lotto.getNumbers();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
