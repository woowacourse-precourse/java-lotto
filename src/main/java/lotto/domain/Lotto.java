package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateOverlap(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto issue() {
        ArrayList<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
