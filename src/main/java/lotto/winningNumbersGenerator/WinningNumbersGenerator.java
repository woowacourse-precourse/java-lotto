package lotto.winningNumbersGenerator;

import lotto.numbers.WinningNumbers;

public interface WinningNumbersGenerator {
    public WinningNumbers generateWinningNumbers(String mainNumbers, String bonusNumber);
}
