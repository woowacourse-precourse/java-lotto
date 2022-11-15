package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        System.out.println(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
