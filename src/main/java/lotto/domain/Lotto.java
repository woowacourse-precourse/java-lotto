package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(numbers);
        this.numbers = numbers;
        show(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void show(List<Integer> numbers){
        System.out.println(numbers);
    }

}
