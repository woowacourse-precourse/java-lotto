package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        int count = 0;
        for (int number : numbers) {
            count += lotto.containNumber(number);
        }
        return count;
    }

    public boolean isBonus(Lotto lotto) {
        if (lotto.containNumber(bonusNumber) == 1) {
            return true;
        }
        return false;
    }
}
