package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int SIZE = 6;
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

    public static Lotto createRandomNumbers() {
        Set<Integer> randomNumberSet = new HashSet<>();
        while (randomNumberSet.size() != SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            randomNumberSet.add(randomNumber);
        }
        List<Integer> randomNumberList = new ArrayList<>(randomNumberSet);
        return new Lotto(randomNumberList);
    }

}
