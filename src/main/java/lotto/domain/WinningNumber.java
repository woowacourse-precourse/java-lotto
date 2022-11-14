package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
