package lotto.domain;

import java.util.List;

public class WinningLotto {
    private List<Integer> numbers;
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
