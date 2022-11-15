package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final String NUMBER_SEPARATOR = ",";
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public int getContainValue(Integer number) {
        if (isContain(number)) {
            return 1;
        }
        return 0;
    }

    public int getMatchedCount(Lotto compareLotto) {
        int matchedCount = 0;
        for (Integer number : numbers) {
            matchedCount += compareLotto.getContainValue(number);
        }
        return matchedCount;
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        List<String> stringNumbers = numbers.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(NUMBER_SEPARATOR, stringNumbers);
    }
}