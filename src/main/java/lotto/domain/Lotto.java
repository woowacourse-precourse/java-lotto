package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int SIZE = 6;
    public static final String SIZE_ERROR_MESSAGE = "[ERROR]: 로또 번호가 " + SIZE + "개의 숫자가 아닙니다.\n";
    public static final String DUPLICATION_ERROR_MESSAGE = "[ERROR]: 로또 번호에 중복된 숫자가 있습니다.\n";
    public static final String SCOPE_ERROR_MESSAGE = "[ERROR]: 로또 번호가 " + MIN_VALUE + "~" + MAX_VALUE + "사이 숫자가 아닙니다.\n";
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> list = new ArrayList<>(numbers);
        list.sort(Comparator.naturalOrder());
        this.numbers = list;

    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumberScope(numbers);
    }

    public static Lotto createRandomNumbers() {
        List<Integer> randomList = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);
        List<Integer> randomNumberList = new ArrayList<>(randomList);
        Collections.sort(randomNumberList);
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

    public void validateNumberScope(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= MIN_VALUE && number <= MAX_VALUE)) {
                throw new IllegalArgumentException(SCOPE_ERROR_MESSAGE);
            }
        }
    }
}
