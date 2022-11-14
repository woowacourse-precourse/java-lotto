package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setBonusNumber(int number) {
        bonusNumber = number;
    }

    public int getMatchingCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
