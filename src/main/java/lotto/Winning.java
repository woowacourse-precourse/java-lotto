package lotto;

import java.util.List;

import static lotto.Prize.*;

public class Winning {
    private static final Prize[] PRIZES = {FIFTH, FORTH, THIRD, SECOND, FIRST};
    private final List<Integer> numbers;
    private final int bonusNumber;

    Winning(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

}
