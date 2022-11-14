package lotto.domain.lotto;

import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
