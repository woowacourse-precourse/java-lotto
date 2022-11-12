package lotto.domain;

import lotto.Game;
import lotto.check.Check;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void myLotto(String cash){
        int myLottoCount = Integer.parseInt(cash) / Check.UNIT;
        Game.myAutoLotto(myLottoCount);
    }
}
