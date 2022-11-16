package lotto.domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> number;
    private int bonus;

    public List<Integer> getNumber() {
        return number;
    }

    public int getBonus() {
        return bonus;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
