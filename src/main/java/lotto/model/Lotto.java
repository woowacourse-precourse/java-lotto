package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int count = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM, MAXIMUM, count));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}

