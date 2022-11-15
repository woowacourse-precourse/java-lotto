package lotto.domain;

import java.util.List;

public class WinningNumbers extends Lotto {
    private List<Integer> numbers;
    private int bonus;

    public WinningNumbers(List<Integer> numbers, int bonus) {
        super(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
