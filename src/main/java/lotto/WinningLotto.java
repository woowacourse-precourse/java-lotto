package lotto;

import java.util.List;

import static lotto.Game.checker;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this(numbers);
        checker.checkBoundary(bonusNumber);
        checker.checkDuplicated(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "numbers=" + this.getNumbers() +
                "bonusNumber=" + bonusNumber +
                '}';
    }
}
