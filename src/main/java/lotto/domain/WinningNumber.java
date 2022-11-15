package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonus;

    public WinningNumber(Lotto numbers, int bonus) {
        this.winningNumber = numbers;
        this.bonus = bonus;
    }

    public Lotto getNumbers() {
        return winningNumber;
    }

    public int getBonus() {
        return bonus;
    }
}
