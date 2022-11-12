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
    public static final String SIZE_ERROR_MESSAGE = "[ERROR]: 로또 번호가 " + SIZE + "개의 숫자가 아닙니다.\n";
    public static final String DUPLICATION_ERROR_MESSAGE = "[ERROR]: 로또 번호에 중복된 숫자가 있습니다.\n";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
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

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            numberSet.add(number);
        }
        if (numberSet.size() != SIZE) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }
}
