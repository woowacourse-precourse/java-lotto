package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> number;
    private final int bonus;

    public WinningNumber(List<Integer> number, int bonus) {
        this.number = number;
        this.bonus = bonus;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int getBonus() {
        return bonus;
    }
}
