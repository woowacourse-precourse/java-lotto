package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    public int num_lotto(int money) {
        int num = 0;
        num = money / 1000 ;
        if (num % money != 0) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    // TODO: 추가 기능 구현
}
