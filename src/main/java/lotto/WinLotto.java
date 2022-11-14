package lotto;

import java.util.List;

public class WinLotto {
    final List<Integer> numbers;
    int bonus;

    public WinLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
