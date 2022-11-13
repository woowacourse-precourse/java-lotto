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
}
