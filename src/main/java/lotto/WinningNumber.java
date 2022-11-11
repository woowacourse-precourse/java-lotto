package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        NumbersValidator.validateWinningNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public long countMatchedNumbers(Lotto lotto){
        return lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isBonusNumberMatched(Lotto lotto){
        return lotto.getNumbers().contains(bonusNumber);
    }
}
