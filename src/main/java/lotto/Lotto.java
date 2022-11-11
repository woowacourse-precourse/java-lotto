package lotto;

import lotto.CheckInputException;

import java.util.List;

public class Lotto {

    private static Integer bonusNumber;
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

    public static void setBonusNumber(Integer bonusNumber) {
        Lotto.bonusNumber = bonusNumber;
    }

    // TODO: 추가 기능 구현
}
